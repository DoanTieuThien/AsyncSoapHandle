package com.its.pwebservice.handle;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.its.pwebservice.models.DataTransferModel;
import com.its.webservice.ws.itsdatatypes.QueryCourseInfoResponseType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoResponseType;

public class MonitorEventHandle implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(MonitorEventHandle.class);

	private ThreadPoolExecutor threadPoolExecutor = null;
	@Autowired
	@Qualifier("monitorDataQueue")
	public LinkedBlockingQueue<DataTransferModel> monitorDataQueue = null;

	public MonitorEventHandle(ThreadPoolExecutor pool) {
		this.threadPoolExecutor = pool;
	}

	@Override
	public void run() {
		while (!this.threadPoolExecutor.isTerminated()) {
			try {
				DataTransferModel data = monitorDataQueue.poll();

				if (data == null) {
					Thread.sleep(100);
					continue;
				}
				log.info("Have response data is responsed from server");
				Object o = data.getPayload();

				if (o == null) {
					Thread.sleep(100);
					continue;
				}
				if (o instanceof QueryStudentInfoResponseType) {
					QueryStudentInfoResponseType response = (QueryStudentInfoResponseType) o;
					log.info("Have student info: " + response.getFullName() + ",document "
							+ response.getDocumentNumber() + ", app name = " + data.getHeaderType().getAppName());
				} else if (o instanceof QueryCourseInfoResponseType) {
					QueryCourseInfoResponseType response = (QueryCourseInfoResponseType) o;
					log.info("Have course info: " + response.getName() + ",course time " + response.getCourseTime()
							+ ", app name = " + data.getHeaderType().getAppName());
				}
			} catch (Exception exp) {
				exp.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
