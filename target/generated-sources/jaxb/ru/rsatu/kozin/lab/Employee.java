//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.07 at 10:26:46 PM MSK 
//


package ru.rsatu.kozin.lab;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for employee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="employee"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://lab.kozin.rsatu.ru/}man"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="employeeDoc" type="{http://lab.kozin.rsatu.ru/}doc"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employee", propOrder = {
    "employeeDoc"
})
public class Employee
    extends Man
{

    @XmlElement(required = true)
    protected Doc employeeDoc;

    /**
     * Gets the value of the employeeDoc property.
     * 
     * @return
     *     possible object is
     *     {@link Doc }
     *     
     */
    public Doc getEmployeeDoc() {
        return employeeDoc;
    }

    /**
     * Sets the value of the employeeDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Doc }
     *     
     */
    public void setEmployeeDoc(Doc value) {
        this.employeeDoc = value;
    }

}
