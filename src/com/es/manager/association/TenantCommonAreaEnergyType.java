//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.27 at 11:59:11 PM EDT 
//


package com.es.manager.association;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tenantCommonAreaEnergyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tenantCommonAreaEnergyType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Tenant Heating"/&gt;
 *     &lt;enumeration value="Tenant Cooling"/&gt;
 *     &lt;enumeration value="Tenant Hot Water"/&gt;
 *     &lt;enumeration value="Tenant Plug Load/Electricity"/&gt;
 *     &lt;enumeration value="Common Area Heating"/&gt;
 *     &lt;enumeration value="Common Area Cooling"/&gt;
 *     &lt;enumeration value="Common Area Hot Water"/&gt;
 *     &lt;enumeration value="Common Area Plug Load/Electricity"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tenantCommonAreaEnergyType")
@XmlEnum
public enum TenantCommonAreaEnergyType {

    @XmlEnumValue("Tenant Heating")
    TENANT_HEATING("Tenant Heating"),
    @XmlEnumValue("Tenant Cooling")
    TENANT_COOLING("Tenant Cooling"),
    @XmlEnumValue("Tenant Hot Water")
    TENANT_HOT_WATER("Tenant Hot Water"),
    @XmlEnumValue("Tenant Plug Load/Electricity")
    TENANT_PLUG_LOAD_ELECTRICITY("Tenant Plug Load/Electricity"),
    @XmlEnumValue("Common Area Heating")
    COMMON_AREA_HEATING("Common Area Heating"),
    @XmlEnumValue("Common Area Cooling")
    COMMON_AREA_COOLING("Common Area Cooling"),
    @XmlEnumValue("Common Area Hot Water")
    COMMON_AREA_HOT_WATER("Common Area Hot Water"),
    @XmlEnumValue("Common Area Plug Load/Electricity")
    COMMON_AREA_PLUG_LOAD_ELECTRICITY("Common Area Plug Load/Electricity");
    private final String value;

    TenantCommonAreaEnergyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TenantCommonAreaEnergyType fromValue(String v) {
        for (TenantCommonAreaEnergyType c: TenantCommonAreaEnergyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
