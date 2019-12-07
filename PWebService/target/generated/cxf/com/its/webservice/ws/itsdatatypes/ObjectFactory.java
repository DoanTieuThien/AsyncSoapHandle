
package com.its.webservice.ws.itsdatatypes;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.its.webservice.ws.itsdatatypes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.its.webservice.ws.itsdatatypes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HeaderType }
     * 
     */
    public HeaderType createHeaderType() {
        return new HeaderType();
    }

    /**
     * Create an instance of {@link ProcessMessageType }
     * 
     */
    public ProcessMessageType createProcessMessageType() {
        return new ProcessMessageType();
    }

    /**
     * Create an instance of {@link RetResultType }
     * 
     */
    public RetResultType createRetResultType() {
        return new RetResultType();
    }

    /**
     * Create an instance of {@link AuthDetailsType }
     * 
     */
    public AuthDetailsType createAuthDetailsType() {
        return new AuthDetailsType();
    }

    /**
     * Create an instance of {@link QueryStudentInfoRequestType }
     * 
     */
    public QueryStudentInfoRequestType createQueryStudentInfoRequestType() {
        return new QueryStudentInfoRequestType();
    }

    /**
     * Create an instance of {@link QueryStudentInfoResponseType }
     * 
     */
    public QueryStudentInfoResponseType createQueryStudentInfoResponseType() {
        return new QueryStudentInfoResponseType();
    }

    /**
     * Create an instance of {@link QueryCourseInfoRequestType }
     * 
     */
    public QueryCourseInfoRequestType createQueryCourseInfoRequestType() {
        return new QueryCourseInfoRequestType();
    }

    /**
     * Create an instance of {@link QueryCourseInfoResponseType }
     * 
     */
    public QueryCourseInfoResponseType createQueryCourseInfoResponseType() {
        return new QueryCourseInfoResponseType();
    }

}
