package com.its.webservice.config.models;

import java.io.Serializable;

import com.its.webservice.ws.itsdatatypes.HeaderType;

public class DataTransferModel implements Serializable {
	private HeaderType headerType;
	private Object payload;

	public HeaderType getHeaderType() {
		return headerType;
	}

	public void setHeaderType(HeaderType headerType) {
		this.headerType = headerType;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
}
