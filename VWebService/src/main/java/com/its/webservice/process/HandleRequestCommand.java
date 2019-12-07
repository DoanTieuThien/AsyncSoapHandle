package com.its.webservice.process;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.its.webservice.bussiness.VWebServiceBussiness;
import com.its.webservice.config.models.DataTransferModel;
import com.its.webservice.ws.itsdatatypes.QueryCourseInfoRequestType;
import com.its.webservice.ws.itsdatatypes.QueryCourseInfoResponseType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoRequestType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoResponseType;

public class HandleRequestCommand implements Runnable {
	private static final Logger log = LoggerFactory.getLogger(HandleRequestCommand.class);
	@Autowired
	@Qualifier("requestCommandQueue")
	private LinkedBlockingQueue<DataTransferModel> requestCommandQueue = null;
	public ThreadPoolExecutor threadPoolExecutor = null;
	@Autowired
	@Qualifier("managerApp")
	public ConcurrentHashMap<String, LinkedBlockingQueue> managerApp = null;

	@Autowired
	private VWebServiceBussiness vwebServiceBussiness = null;

	public HandleRequestCommand(ThreadPoolExecutor pool) {
		this.threadPoolExecutor = pool;
	}

	@Override
	public void run() {
		//tien trinh doc command u queue request de xac dinh co ban tin den ko
		while (!this.threadPoolExecutor.isTerminated()) {
			try {
				DataTransferModel request = this.requestCommandQueue.poll();

				if (request == null) {
					Thread.sleep(100);
					continue;
				}
				Object o = request.getPayload();

				if (o == null) {
					Thread.sleep(100);
					continue;
				}
				Object res = null;

				//xac dinh loai request la gi o day tra cuu
				if (o instanceof QueryStudentInfoRequestType) {
					//tra cuu sinh vien se tra cuu ra ket qua
					QueryStudentInfoRequestType queryStudentInfoRequestType = (QueryStudentInfoRequestType) o;
					QueryStudentInfoResponseType response = this.vwebServiceBussiness
							.loadStudentInfo(queryStudentInfoRequestType);
					res = response;
				} else if (o instanceof QueryCourseInfoRequestType) {
					//tra cuu khoa hoc
					QueryCourseInfoRequestType queryCourseInfoResponseType = (QueryCourseInfoRequestType) o;
					QueryCourseInfoResponseType response = this.vwebServiceBussiness
							.loadCourseInfo(queryCourseInfoResponseType);
					res = response;
				}
				DataTransferModel resRequest = new DataTransferModel();
				resRequest.setHeaderType(request.getHeaderType());
				resRequest.setPayload(res);
				
				//sau khi tra cuu xong se kiem tra trong managerApp xem co bao nhieu APP hien tai dang dang ky ket noi
				//den serrver core
				LinkedBlockingQueue<DataTransferModel> responseQueue = managerApp
						.get(request.getHeaderType().getAppName());

				if (responseQueue != null) {
					//sau khi thay co APPNAME tuong ung voi APP da dang ky se day vao queue tuong ung
					responseQueue.put(resRequest);
					responseQueue = null;
				}
				Thread.sleep(10);
				continue;
			} catch (Exception exp) {
				exp.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
