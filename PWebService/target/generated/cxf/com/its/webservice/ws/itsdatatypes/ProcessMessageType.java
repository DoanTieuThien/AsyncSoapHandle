
package com.its.webservice.ws.itsdatatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="queryStudentInfoMessage" type="{http://ws.webservice.its.com/itsDataTypes}QueryStudentInfoRequestType"/&gt;
 *         &lt;element name="queryCourseInfoMessage" type="{http://ws.webservice.its.com/itsDataTypes}QueryCourseInfoRequestType"/&gt;
 *         &lt;element name="dataStudentInfoMessage" type="{http://ws.webservice.its.com/itsDataTypes}QueryStudentInfoResponseType"/&gt;
 *         &lt;element name="dataCourseInfoMessage" type="{http://ws.webservice.its.com/itsDataTypes}QueryCourseInfoResponseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessMessageType", propOrder = {
    "queryStudentInfoMessage",
    "queryCourseInfoMessage",
    "dataStudentInfoMessage",
    "dataCourseInfoMessage"
})
public class ProcessMessageType {

    @XmlElement(required = true)
    protected QueryStudentInfoRequestType queryStudentInfoMessage;
    @XmlElement(required = true)
    protected QueryCourseInfoRequestType queryCourseInfoMessage;
    @XmlElement(required = true)
    protected QueryStudentInfoResponseType dataStudentInfoMessage;
    @XmlElement(required = true)
    protected QueryCourseInfoResponseType dataCourseInfoMessage;

    /**
     * Gets the value of the queryStudentInfoMessage property.
     * 
     * @return
     *     possible object is
     *     {@link QueryStudentInfoRequestType }
     *     
     */
    public QueryStudentInfoRequestType getQueryStudentInfoMessage() {
        return queryStudentInfoMessage;
    }

    /**
     * Sets the value of the queryStudentInfoMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryStudentInfoRequestType }
     *     
     */
    public void setQueryStudentInfoMessage(QueryStudentInfoRequestType value) {
        this.queryStudentInfoMessage = value;
    }

    /**
     * Gets the value of the queryCourseInfoMessage property.
     * 
     * @return
     *     possible object is
     *     {@link QueryCourseInfoRequestType }
     *     
     */
    public QueryCourseInfoRequestType getQueryCourseInfoMessage() {
        return queryCourseInfoMessage;
    }

    /**
     * Sets the value of the queryCourseInfoMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryCourseInfoRequestType }
     *     
     */
    public void setQueryCourseInfoMessage(QueryCourseInfoRequestType value) {
        this.queryCourseInfoMessage = value;
    }

    /**
     * Gets the value of the dataStudentInfoMessage property.
     * 
     * @return
     *     possible object is
     *     {@link QueryStudentInfoResponseType }
     *     
     */
    public QueryStudentInfoResponseType getDataStudentInfoMessage() {
        return dataStudentInfoMessage;
    }

    /**
     * Sets the value of the dataStudentInfoMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryStudentInfoResponseType }
     *     
     */
    public void setDataStudentInfoMessage(QueryStudentInfoResponseType value) {
        this.dataStudentInfoMessage = value;
    }

    /**
     * Gets the value of the dataCourseInfoMessage property.
     * 
     * @return
     *     possible object is
     *     {@link QueryCourseInfoResponseType }
     *     
     */
    public QueryCourseInfoResponseType getDataCourseInfoMessage() {
        return dataCourseInfoMessage;
    }

    /**
     * Sets the value of the dataCourseInfoMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryCourseInfoResponseType }
     *     
     */
    public void setDataCourseInfoMessage(QueryCourseInfoResponseType value) {
        this.dataCourseInfoMessage = value;
    }

}
