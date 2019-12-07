package com.its.webservice.bussiness.manager;

import org.springframework.stereotype.Service;

import com.its.webservice.bussiness.VWebServiceBussiness;
import com.its.webservice.ws.itsdatatypes.QueryCourseInfoRequestType;
import com.its.webservice.ws.itsdatatypes.QueryCourseInfoResponseType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoRequestType;
import com.its.webservice.ws.itsdatatypes.QueryStudentInfoResponseType;

@Service("VWebServiceBussinessManager")
public class VWebServiceBussinessManager  implements VWebServiceBussiness{

	@Override
	public QueryStudentInfoResponseType loadStudentInfo(QueryStudentInfoRequestType request) throws Exception {
		QueryStudentInfoResponseType response = new QueryStudentInfoResponseType();
		
		response.setAge("25");
		response.setClassName("Lop 1B");
		response.setCourse("DTVT");
		response.setDocumentNumber("123456789");
		response.setFullName("Nguyen Xuan Tuan");
		response.setTeacher("OH OH");
		return response;
	}

	@Override
	public QueryCourseInfoResponseType loadCourseInfo(QueryCourseInfoRequestType request) throws Exception {
		QueryCourseInfoResponseType response = new QueryCourseInfoResponseType();
		
		response.setName("Khoa hoc ung dung demo");
		response.setCourseTime("3 thang");
		response.setStartDateTime("07/12/2019");
		response.setSpecialized("Ung dung");
		return response;
	}

}
