package com.its.webservice.process;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.its.webservice.config.models.DataTransferModel;
import com.its.webservice.ws.VWebServicePortType;
import com.its.webservice.ws.itsdatatypes.HeaderType;
import com.its.webservice.ws.itsdatatypes.ProcessMessageType;
import com.its.webservice.ws.itsdatatypes.QueryCourseInfoResponseType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoResponseType;
import com.its.webservice.ws.itsdatatypes.RetResultType;

public class HandleResponseCommand implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(HandleResponseCommand.class);

	private LinkedBlockingQueue<DataTransferModel> responseCommandQueue = null;
	public VWebServicePortType vwebServicePortTypeClient = null;
	public ThreadPoolExecutor threadPoolExecutor = null;

	public HandleResponseCommand(LinkedBlockingQueue<DataTransferModel> queue, ThreadPoolExecutor pool,
			VWebServicePortType vwebServicePortTypeClient) {
		this.responseCommandQueue = queue;
		this.threadPoolExecutor = pool;
		this.vwebServicePortTypeClient = vwebServicePortTypeClient;
	}

	@Override
	public void run() {
		//tien trinh doc ban tin response tuog ung voi APP de tra ket qua
		while (!this.threadPoolExecutor.isTerminated()) {
			try {
				DataTransferModel response = this.responseCommandQueue.poll();

				if (response == null) {
					Thread.sleep(100);
					continue;
				}
				log.info("Have response data to client");
				Object o = response.getPayload();

				if (o == null) {
					Thread.sleep(100);
					continue;
				}
				HeaderType headerType = response.getHeaderType();
				ProcessMessageType processMessageType = new ProcessMessageType();

				if (o instanceof QueryStudentInfoResponseType) {
					headerType.setMessageName("dataStudentInfoMessage");
					processMessageType.setDataStudentInfoMessage((QueryStudentInfoResponseType) o);
				} else if (o instanceof QueryCourseInfoResponseType) {
					headerType.setMessageName("dataCourseInfoMessage");
					processMessageType.setDataCourseInfoMessage((QueryCourseInfoResponseType) o);
				}
				try {
					//o day do dung SOAP API lam phuong thuc nen APP vua la CLIENT vua la SERRVER
					RetResultType resultType = this.vwebServicePortTypeClient.processWebService(headerType,
							processMessageType);
					log.info("Finished transfer data with retResult " + resultType.getStatus() + ", message "
							+ resultType.getMessage() + ", transaction id " + resultType.getTransactionId() + ",app " + headerType.getAppName());
				} catch (Exception exp) {
					log.error("Error when request to client " + headerType, exp);
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
