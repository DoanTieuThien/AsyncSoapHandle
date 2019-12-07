package com.its.webservice.bussiness;

import com.its.webservice.ws.itsdatatypes.QueryCourseInfoRequestType;
import com.its.webservice.ws.itsdatatypes.QueryCourseInfoResponseType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoRequestType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoResponseType;

public interface VWebServiceBussiness {
	public QueryStudentInfoResponseType loadStudentInfo(QueryStudentInfoRequestType request) throws Exception;

	public QueryCourseInfoResponseType loadCourseInfo(QueryCourseInfoRequestType request) throws Exception;
}
