
package com.its.webservice.ws.itsdatatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthDetailsType" type="{http://ws.webservice.its.com/itsDataTypes}AuthDetailsType"/&gt;
 *         &lt;element name="MessageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EventDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TansactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AppName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderType", propOrder = {
    "authDetailsType",
    "messageName",
    "eventDateTime",
    "tansactionId",
    "appName"
})
public class HeaderType {

    @XmlElement(name = "AuthDetailsType", required = true)
    protected AuthDetailsType authDetailsType;
    @XmlElement(name = "MessageName")
    protected String messageName;
    @XmlElement(name = "EventDateTime")
    protected String eventDateTime;
    @XmlElement(name = "TansactionId")
    protected String tansactionId;
    @XmlElement(name = "AppName")
    protected String appName;

    /**
     * Gets the value of the authDetailsType property.
     * 
     * @return
     *     possible object is
     *     {@link AuthDetailsType }
     *     
     */
    public AuthDetailsType getAuthDetailsType() {
        return authDetailsType;
    }

    /**
     * Sets the value of the authDetailsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthDetailsType }
     *     
     */
    public void setAuthDetailsType(AuthDetailsType value) {
        this.authDetailsType = value;
    }

    /**
     * Gets the value of the messageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageName() {
        return messageName;
    }

    /**
     * Sets the value of the messageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageName(String value) {
        this.messageName = value;
    }

    /**
     * Gets the value of the eventDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDateTime() {
        return eventDateTime;
    }

    /**
     * Sets the value of the eventDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDateTime(String value) {
        this.eventDateTime = value;
    }

    /**
     * Gets the value of the tansactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTansactionId() {
        return tansactionId;
    }

    /**
     * Sets the value of the tansactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTansactionId(String value) {
        this.tansactionId = value;
    }

    /**
     * Gets the value of the appName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Sets the value of the appName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppName(String value) {
        this.appName = value;
    }

}
