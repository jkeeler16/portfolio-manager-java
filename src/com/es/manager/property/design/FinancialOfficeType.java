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
import com.es.manager.property.use.UseDecimalType;


/**
 * <p>Java class for financialOfficeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="financialOfficeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="name" type="{}propertyUseNameType"/&gt;
 *         &lt;element name="useDetails"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;all&gt;
 *                   &lt;element ref="{}totalGrossFloorArea"/&gt;
 *                   &lt;element ref="{}numberOfComputers" minOccurs="0"/&gt;
 *                   &lt;element ref="{}percentOfficeCooled" minOccurs="0"/&gt;
 *                   &lt;element ref="{}percentOfficeHeated" minOccurs="0"/&gt;
 *                   &lt;element ref="{}weeklyOperatingHours" minOccurs="0"/&gt;
 *                   &lt;element ref="{}numberOfWorkers" minOccurs="0"/&gt;
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
@XmlType(name = "financialOfficeType", propOrder = {

})
@XmlRootElement(name="financialOffice")
public class FinancialOfficeType extends BasePropertyUseType{

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected FinancialOfficeType.UseDetails useDetails;
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
     *     {@link FinancialOfficeType.UseDetails }
     *     
     */
    public FinancialOfficeType.UseDetails getUseDetails() {
        return useDetails;
    }

    /**
     * Sets the value of the useDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialOfficeType.UseDetails }
     *     
     */
    public void setUseDetails(FinancialOfficeType.UseDetails value) {
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
     *         &lt;element ref="{}totalGrossFloorArea"/&gt;
     *         &lt;element ref="{}numberOfComputers" minOccurs="0"/&gt;
     *         &lt;element ref="{}percentOfficeCooled" minOccurs="0"/&gt;
     *         &lt;element ref="{}percentOfficeHeated" minOccurs="0"/&gt;
     *         &lt;element ref="{}weeklyOperatingHours" minOccurs="0"/&gt;
     *         &lt;element ref="{}numberOfWorkers" minOccurs="0"/&gt;
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
        protected GrossFloorAreaType totalGrossFloorArea;
        protected UseDecimalType numberOfComputers;
        protected PercentOfficeCooledType percentOfficeCooled;
        protected PercentOfficeHeatedType percentOfficeHeated;
        protected UseDecimalType weeklyOperatingHours;
        protected UseDecimalType numberOfWorkers;

        /**
         * Gets the value of the totalGrossFloorArea property.
         * 
         * @return
         *     possible object is
         *     {@link GrossFloorAreaType }
         *     
         */
        public GrossFloorAreaType getTotalGrossFloorArea() {
            return totalGrossFloorArea;
        }

        /**
         * Sets the value of the totalGrossFloorArea property.
         * 
         * @param value
         *     allowed object is
         *     {@link GrossFloorAreaType }
         *     
         */
        public void setTotalGrossFloorArea(GrossFloorAreaType value) {
            this.totalGrossFloorArea = value;
        }

        /**
         * Gets the value of the numberOfComputers property.
         * 
         * @return
         *     possible object is
         *     {@link UseDecimalType }
         *     
         */
        public UseDecimalType getNumberOfComputers() {
            return numberOfComputers;
        }

        /**
         * Sets the value of the numberOfComputers property.
         * 
         * @param value
         *     allowed object is
         *     {@link UseDecimalType }
         *     
         */
        public void setNumberOfComputers(UseDecimalType value) {
            this.numberOfComputers = value;
        }

        /**
         * Gets the value of the percentOfficeCooled property.
         * 
         * @return
         *     possible object is
         *     {@link PercentOfficeCooledType }
         *     
         */
        public PercentOfficeCooledType getPercentOfficeCooled() {
            return percentOfficeCooled;
        }

        /**
         * Sets the value of the percentOfficeCooled property.
         * 
         * @param value
         *     allowed object is
         *     {@link PercentOfficeCooledType }
         *     
         */
        public void setPercentOfficeCooled(PercentOfficeCooledType value) {
            this.percentOfficeCooled = value;
        }

        /**
         * Gets the value of the percentOfficeHeated property.
         * 
         * @return
         *     possible object is
         *     {@link PercentOfficeHeatedType }
         *     
         */
        public PercentOfficeHeatedType getPercentOfficeHeated() {
            return percentOfficeHeated;
        }

        /**
         * Sets the value of the percentOfficeHeated property.
         * 
         * @param value
         *     allowed object is
         *     {@link PercentOfficeHeatedType }
         *     
         */
        public void setPercentOfficeHeated(PercentOfficeHeatedType value) {
            this.percentOfficeHeated = value;
        }

        /**
         * Gets the value of the weeklyOperatingHours property.
         * 
         * @return
         *     possible object is
         *     {@link UseDecimalType }
         *     
         */
        public UseDecimalType getWeeklyOperatingHours() {
            return weeklyOperatingHours;
        }

        /**
         * Sets the value of the weeklyOperatingHours property.
         * 
         * @param value
         *     allowed object is
         *     {@link UseDecimalType }
         *     
         */
        public void setWeeklyOperatingHours(UseDecimalType value) {
            this.weeklyOperatingHours = value;
        }

        /**
         * Gets the value of the numberOfWorkers property.
         * 
         * @return
         *     possible object is
         *     {@link UseDecimalType }
         *     
         */
        public UseDecimalType getNumberOfWorkers() {
            return numberOfWorkers;
        }

        /**
         * Sets the value of the numberOfWorkers property.
         * 
         * @param value
         *     allowed object is
         *     {@link UseDecimalType }
         *     
         */
        public void setNumberOfWorkers(UseDecimalType value) {
            this.numberOfWorkers = value;
        }

    }

}
