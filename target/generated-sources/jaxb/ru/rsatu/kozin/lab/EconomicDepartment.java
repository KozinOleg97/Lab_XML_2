//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.09 at 08:47:48 PM MSK 
//


package ru.rsatu.kozin.lab;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for economicDepartment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="economicDepartment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://lab.kozin.rsatu.ru/}department"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cafe" type="{http://lab.kozin.rsatu.ru/}department"/&gt;
 *         &lt;element name="staffDepartment" type="{http://lab.kozin.rsatu.ru/}department"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "economicDepartment", propOrder = {
    "cafe",
    "staffDepartment"
})
public class EconomicDepartment
    extends Department
{

    @XmlElement(required = true)
    protected Department cafe;
    @XmlElement(required = true)
    protected Department staffDepartment;

    /**
     * Gets the value of the cafe property.
     * 
     * @return
     *     possible object is
     *     {@link Department }
     *     
     */
    public Department getCafe() {
        return cafe;
    }

    /**
     * Sets the value of the cafe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Department }
     *     
     */
    public void setCafe(Department value) {
        this.cafe = value;
    }

    /**
     * Gets the value of the staffDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link Department }
     *     
     */
    public Department getStaffDepartment() {
        return staffDepartment;
    }

    /**
     * Sets the value of the staffDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Department }
     *     
     */
    public void setStaffDepartment(Department value) {
        this.staffDepartment = value;
    }

}
