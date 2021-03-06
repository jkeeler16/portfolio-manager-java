//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.28 at 12:35:27 AM EDT 
//


package com.es.manager.property.design;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The total gross floor area of all buildings at the property, measured at the exterior boundary of the enclosing walls, including all areas within the building (common, tenant, maintenance, etc). 
 * 
 * <p>Java class for grossFloorAreaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="grossFloorAreaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{}floorAreaTypeBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "grossFloorAreaType", propOrder = {
    "value"
})
@XmlRootElement(name="totalGrossFloorArea")
public class GrossFloorAreaType
    extends FloorAreaTypeBase
{

    protected int value;

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}
