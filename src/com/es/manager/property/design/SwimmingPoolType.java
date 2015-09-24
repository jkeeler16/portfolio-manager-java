//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.28 at 12:35:27 AM EDT 
//


package com.es.manager.property.design;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.es.manager.common.LogType;


/**
 * <p>Java class for swimmingPoolType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="swimmingPoolType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="name" type="{}propertyUseNameType"/&gt;
 *         &lt;element name="useDetails"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element ref="{}poolSize"/&gt;
 *                   &lt;element ref="{}poolLocation" minOccurs="0"/&gt;
 *                   &lt;element ref="{}monthsInUse" minOccurs="0"/&gt;
 *                 &lt;/all&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="audit" type="{}logType" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "swimmingPoolType", propOrder = {

})
@XmlRootElement(name="swimmingPool")
public class SwimmingPoolType extends BasePropertyUseType{

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected SwimmingPoolType.UseDetails useDetails;
    protected LogType audit;

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
     * Gets the value of the useDetails property.
     * 
     * @return
     *     possible object is
     *     {@link SwimmingPoolType.UseDetails }
     *     
     */
    public SwimmingPoolType.UseDetails getUseDetails() {
        return useDetails;
    }

    /**
     * Sets the value of the useDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link SwimmingPoolType.UseDetails }
     *     
     */
    public void setUseDetails(SwimmingPoolType.UseDetails value) {
        this.useDetails = value;
    }

    /**
     * Gets the value of the audit property.
     * 
     * @return
     *     possible object is
     *     {@link LogType }
     *     
     */
    public LogType getAudit() {
        return audit;
    }

    /**
     * Sets the value of the audit property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogType }
     *     
     */
    public void setAudit(LogType value) {
        this.audit = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;all&gt;
     *         &lt;element ref="{}poolSize"/&gt;
     *         &lt;element ref="{}poolLocation" minOccurs="0"/&gt;
     *         &lt;element ref="{}monthsInUse" minOccurs="0"/&gt;
     *       &lt;/all&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class UseDetails {

        @XmlElement(required = true)
        protected PoolSizeType poolSize;
        protected PoolType poolLocation;
        protected MonthsInUseType monthsInUse;

        /**
         * Gets the value of the poolSize property.
         * 
         * @return
         *     possible object is
         *     {@link PoolSizeType }
         *     
         */
        public PoolSizeType getPoolSize() {
            return poolSize;
        }

        /**
         * Sets the value of the poolSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link PoolSizeType }
         *     
         */
        public void setPoolSize(PoolSizeType value) {
            this.poolSize = value;
        }

        /**
         * Gets the value of the poolLocation property.
         * 
         * @return
         *     possible object is
         *     {@link PoolType }
         *     
         */
        public PoolType getPoolLocation() {
            return poolLocation;
        }

        /**
         * Sets the value of the poolLocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link PoolType }
         *     
         */
        public void setPoolLocation(PoolType value) {
            this.poolLocation = value;
        }

        /**
         * Gets the value of the monthsInUse property.
         * 
         * @return
         *     possible object is
         *     {@link MonthsInUseType }
         *     
         */
        public MonthsInUseType getMonthsInUse() {
            return monthsInUse;
        }

        /**
         * Sets the value of the monthsInUse property.
         * 
         * @param value
         *     allowed object is
         *     {@link MonthsInUseType }
         *     
         */
        public void setMonthsInUse(MonthsInUseType value) {
            this.monthsInUse = value;
        }

    }

}
