package com.its.pwebservice.porttype;

import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.its.pwebservice.models.DataTransferModel;
import com.its.webservice.ws.VWebServicePortType;
import com.its.webservice.ws.itsdatatypes.HeaderType;
import com.its.webservice.ws.itsdatatypes.ProcessMessageType;
import com.its.webservice.ws.itsdatatypes.RetResultType;

public class PWebServicePortTypeImpl implements VWebServicePortType {

	private static final Logger log = LoggerFactory.getLogger(PWebServicePortTypeImpl.class);
	@Autowired
	@Qualifier("monitorDataQueue")
	public LinkedBlockingQueue<DataTransferModel> monitorDataQueue = null;

	@Override
	public RetResultType processWebService(HeaderType headerType, ProcessMessageType processMessageType) {
		RetResultType retResultType = new RetResultType();
		String transactionId = "";

		try {
			String messageName = Optional.ofNullable(headerType.getMessageName()).orElse("").trim();

			if (!"dataStudentInfoMessage".equalsIgnoreCase(messageName)
					&& !"dataCourseInfoMessage".equalsIgnoreCase(messageName)) {
				transactionId = headerType.getTansactionId();
				retResultType.setStatus("CIENT-00001");
				retResultType.setMessage("Message not supported");
				return retResultType;
			}

			DataTransferModel data = new DataTransferModel();
			
			data.setHeaderType(headerType);
			switch (messageName) {
			case "dataStudentInfoMessage":
				data.setPayload(processMessageType.getDataStudentInfoMessage());
				break;
			case "dataCourseInfoMessage":
				data.setPayload(processMessageType.getDataCourseInfoMessage());
				break;
			}
			this.monitorDataQueue.put(data);
			transactionId = headerType.getTansactionId();
			retResultType.setStatus("CIENT-00000");
			retResultType.setMessage("SUCCESSED");
		} catch (Exception exp) {
			exp.printStackTrace();
			log.error("Error when get response", exp);
			retResultType.setStatus("CIENT-99999");
			retResultType.setMessage(exp.getMessage());
		}
		retResultType.setTransactionId(transactionId);
		return retResultType;
	}

}
