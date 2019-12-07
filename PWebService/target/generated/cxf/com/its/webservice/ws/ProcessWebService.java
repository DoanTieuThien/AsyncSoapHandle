
package com.its.webservice.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.its.webservice.ws.itsdatatypes.HeaderType;
import com.its.webservice.ws.itsdatatypes.ProcessMessageType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="headerType" type="{http://ws.webservice.its.com/itsDataTypes}HeaderType"/&gt;
 *         &lt;element name="processMessageType" type="{http://ws.webservice.its.com/itsDataTypes}ProcessMessageType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "headerType",
    "processMessageType"
})
@XmlRootElement(name = "processWebService")
public class ProcessWebService {

    @XmlElement(required = true)
    protected HeaderType headerType;
    @XmlElement(required = true)
    protected ProcessMessageType processMessageType;

    /**
     * Gets the value of the headerType property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType }
     *     
     */
    public HeaderType getHeaderType() {
        return headerType;
    }

    /**
     * Sets the value of the headerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType }
     *     
     */
    public void setHeaderType(HeaderType value) {
        this.headerType = value;
    }

    /**
     * Gets the value of the processMessageType property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessMessageType }
     *     
     */
    public ProcessMessageType getProcessMessageType() {
        return processMessageType;
    }

    /**
     * Sets the value of the processMessageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessMessageType }
     *     
     */
    public void setProcessMessageType(ProcessMessageType value) {
        this.processMessageType = value;
    }

}
