
package edu.neumont.csc380.soapRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.example.org/bacon}GetRestaurantsRequest"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getRestaurantsRequest"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "GetRestaurantsRequest", namespace = "http://www.example.org/bacon", required = true)
    protected GetRestaurantsRequest getRestaurantsRequest;

    /**
     * Gets the value of the getRestaurantsRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetRestaurantsRequest }
     *     
     */
    public GetRestaurantsRequest getGetRestaurantsRequest() {
        return getRestaurantsRequest;
    }

    /**
     * Sets the value of the getRestaurantsRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRestaurantsRequest }
     *     
     */
    public void setGetRestaurantsRequest(GetRestaurantsRequest value) {
        this.getRestaurantsRequest = value;
    }

}
