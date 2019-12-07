
package com.its.webservice.ws.itsdatatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryStudentInfoResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryStudentInfoResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="studentCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="fullName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="identityNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="className" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="documentNumber" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="teacher" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="course" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryStudentInfoResponseType", propOrder = {
    "studentCode",
    "fullName",
    "identityNumber",
    "className",
    "documentNumber",
    "teacher",
    "course",
    "age"
})
public class QueryStudentInfoResponseType {

    @XmlElement(required = true)
    protected String studentCode;
    @XmlElement(required = true)
    protected String fullName;
    @XmlElement(required = true)
    protected String identityNumber;
    @XmlElement(required = true)
    protected String className;
    @XmlElement(required = true)
    protected String documentNumber;
    @XmlElement(required = true)
    protected String teacher;
    @XmlElement(required = true)
    protected String course;
    @XmlElement(required = true)
    protected String age;

    /**
     * Gets the value of the studentCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStudentCode() {
        return studentCode;
    }

    /**
     * Sets the value of the studentCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStudentCode(String value) {
        this.studentCode = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the identityNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * Sets the value of the identityNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityNumber(String value) {
        this.identityNumber = value;
    }

    /**
     * Gets the value of the className property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the value of the className property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * Gets the value of the documentNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * Sets the value of the documentNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentNumber(String value) {
        this.documentNumber = value;
    }

    /**
     * Gets the value of the teacher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * Sets the value of the teacher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeacher(String value) {
        this.teacher = value;
    }

    /**
     * Gets the value of the course property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourse() {
        return course;
    }

    /**
     * Sets the value of the course property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourse(String value) {
        this.course = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAge(String value) {
        this.age = value;
    }

}
