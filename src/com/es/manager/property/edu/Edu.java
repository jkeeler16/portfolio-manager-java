//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.31 at 01:52:19 PM EDT 
//


package com.es.manager.property.edu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="preferred" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="selected" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="eGridCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="eGridName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "edu")
public class Edu {

    @XmlAttribute(name = "id")
    protected Long id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "preferred")
    protected Boolean preferred;
    @XmlAttribute(name = "selected")
    protected Boolean selected;
    @XmlAttribute(name = "eGridCode")
    protected String eGridCode;
    @XmlAttribute(name = "eGridName")
    protected String eGridName;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

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
     * Gets the value of the preferred property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreferred() {
        return preferred;
    }

    /**
     * Sets the value of the preferred property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreferred(Boolean value) {
        this.preferred = value;
    }

    /**
     * Gets the value of the selected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSelected() {
        return selected;
    }

    /**
     * Sets the value of the selected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSelected(Boolean value) {
        this.selected = value;
    }

    /**
     * Gets the value of the eGridCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEGridCode() {
        return eGridCode;
    }

    /**
     * Sets the value of the eGridCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEGridCode(String value) {
        this.eGridCode = value;
    }

    /**
     * Gets the value of the eGridName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEGridName() {
        return eGridName;
    }

    /**
     * Sets the value of the eGridName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEGridName(String value) {
        this.eGridName = value;
    }

}
