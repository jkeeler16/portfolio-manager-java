package com.es.manager.property.design;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.es.manager.property.use.UseYesNoType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="hasLaboratory")
public class HasLaboratoryType extends UseYesNoType {

}