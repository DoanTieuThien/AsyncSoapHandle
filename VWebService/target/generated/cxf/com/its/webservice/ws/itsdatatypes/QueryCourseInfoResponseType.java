
package com.its.webservice.ws.itsdatatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryCourseInfoResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryCourseInfoResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="specialized" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="startDateTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="courseTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryCourseInfoResponseType", propOrder = {
    "name",
    "specialized",
    "startDateTime",
    "courseTime"
})
public class QueryCourseInfoResponseType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String specialized;
    @XmlElement(required = true)
    protected String startDateTime;
    @XmlElement(required = true)
    protected String courseTime;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the specialized property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecialized() {
        return specialized;
    }

    /**
     * Sets the value of the specialized property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecialized(String value) {
        this.specialized = value;
    }

    /**
     * Gets the value of the startDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets the value of the startDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDateTime(String value) {
        this.startDateTime = value;
    }

    /**
     * Gets the value of the courseTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseTime() {
        return courseTime;
    }

    /**
     * Sets the value of the courseTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseTime(String value) {
        this.courseTime = value;
    }

}
