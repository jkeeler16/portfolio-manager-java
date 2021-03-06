//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.28 at 12:02:34 AM EDT 
//


package com.es.manager.property;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for constructionStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="constructionStatusType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Existing"/&gt;
 *     &lt;enumeration value="Project"/&gt;
 *     &lt;enumeration value="Test"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "constructionStatusType")
@XmlEnum
public enum ConstructionStatusType {

    @XmlEnumValue("Existing")
    EXISTING("Existing"),
    @XmlEnumValue("Project")
    PROJECT("Project"),
    @XmlEnumValue("Test")
    TEST("Test");
    private final String value;

    ConstructionStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ConstructionStatusType fromValue(String v) {
        for (ConstructionStatusType c: ConstructionStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
