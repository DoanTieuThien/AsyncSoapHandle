package com.its.webservice.porttype;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.its.webservice.config.models.DataTransferModel;
import com.its.webservice.ws.VWebServicePortType;
import com.its.webservice.ws.itsdatatypes.AuthDetailsType;
import com.its.webservice.ws.itsdatatypes.HeaderType;
import com.its.webservice.ws.itsdatatypes.ProcessMessageType;
import com.its.webservice.ws.itsdatatypes.RetResultType;

public class VWebServicePortTypeImpl implements VWebServicePortType {

	@Autowired
	@Qualifier("requestCommandQueue")
	private LinkedBlockingQueue<DataTransferModel> requestCommandQueue = null;
	@Value("${com.its.webservice.user-name}")
	private String userName = "";
	@Value("${com.its.webservice.password}")
	private String password = "";

	@Override
	public RetResultType processWebService(HeaderType headerType, ProcessMessageType processMessageType) {
		RetResultType retResultType = new RetResultType();

		try {
			//nhan ban tin tu client 
			if (requestCommandQueue.size() > 400000) {

				retResultType.setStatus("WSV-00001");
				retResultType.setMessage("Queue is full, please wait some minutes let try again");
				return retResultType;
			}

			AuthDetailsType authDetailsType = headerType.getAuthDetailsType();
			String userName = Optional.ofNullable(authDetailsType.getUserName()).orElse("").trim();
			String password = Optional.ofNullable(authDetailsType.getPassword()).orElse("").trim();

			if (!this.userName.equalsIgnoreCase(userName) && !this.password.equalsIgnoreCase(password)) {
				retResultType.setStatus("WSV-00002");
				retResultType.setMessage("User name or password incorrect, please try again");
				return retResultType;
			}

			String messageName = Optional.ofNullable(headerType.getMessageName()).orElse("").trim();

			if (!"queryStudentInfoMessage".equalsIgnoreCase(messageName)
					&& !"queryCourseInfoMessage".equalsIgnoreCase(messageName)) {
				retResultType.setStatus("WSV-00003");
				retResultType.setMessage("Message name is not supported, please try with the other message");
				return retResultType;
			}
			Object e = null;
			
			switch (messageName) {
			case "queryStudentInfoMessage":
				e = processMessageType.getQueryStudentInfoMessage();
				break;
			case "queryCourseInfoMessage":
				e = processMessageType.getQueryCourseInfoMessage();
				break;

			}
			String transactionId = UUID.randomUUID().toString();
			DataTransferModel requestCommandModel = new DataTransferModel();
			
			headerType.setTansactionId(transactionId);
			requestCommandModel.setHeaderType(headerType);
			requestCommandModel.setPayload(e);
			
			retResultType.setStatus("WSV-00000");
			retResultType.setMessage("SUCCESSED");
			retResultType.setTransactionId(transactionId);
			
			//tai day se khong xu ly ngay ma dua vao queue ghi nhan xu ly sau.
			requestCommandQueue.put(requestCommandModel);
		} catch (Exception exp) {
			exp.printStackTrace();
			retResultType.setStatus("WSV-99999");
			retResultType.setMessage("Error process: " + exp.getMessage());
		}
		return retResultType;
	}

}
