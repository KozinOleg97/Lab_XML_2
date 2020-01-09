//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.09 at 08:43:02 PM MSK 
//


package ru.rsatu.kozin.lab;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for administration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="administration"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://lab.kozin.rsatu.ru/}department"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookkeeping" type="{http://lab.kozin.rsatu.ru/}bookkeeping"/&gt;
 *         &lt;element name="departmentOfScientific" type="{http://lab.kozin.rsatu.ru/}departmentOfScientific"/&gt;
 *         &lt;element name="economicDepartment" type="{http://lab.kozin.rsatu.ru/}economicDepartment"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "administration", propOrder = {
    "bookkeeping",
    "departmentOfScientific",
    "economicDepartment"
})
public class Administration
    extends Department
{

    @XmlElement(required = true)
    protected Bookkeeping bookkeeping;
    @XmlElement(required = true)
    protected DepartmentOfScientific departmentOfScientific;
    @XmlElement(required = true)
    protected EconomicDepartment economicDepartment;

    /**
     * Gets the value of the bookkeeping property.
     * 
     * @return
     *     possible object is
     *     {@link Bookkeeping }
     *     
     */
    public Bookkeeping getBookkeeping() {
        return bookkeeping;
    }

    /**
     * Sets the value of the bookkeeping property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bookkeeping }
     *     
     */
    public void setBookkeeping(Bookkeeping value) {
        this.bookkeeping = value;
    }

    /**
     * Gets the value of the departmentOfScientific property.
     * 
     * @return
     *     possible object is
     *     {@link DepartmentOfScientific }
     *     
     */
    public DepartmentOfScientific getDepartmentOfScientific() {
        return departmentOfScientific;
    }

    /**
     * Sets the value of the departmentOfScientific property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartmentOfScientific }
     *     
     */
    public void setDepartmentOfScientific(DepartmentOfScientific value) {
        this.departmentOfScientific = value;
    }

    /**
     * Gets the value of the economicDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link EconomicDepartment }
     *     
     */
    public EconomicDepartment getEconomicDepartment() {
        return economicDepartment;
    }

    /**
     * Sets the value of the economicDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link EconomicDepartment }
     *     
     */
    public void setEconomicDepartment(EconomicDepartment value) {
        this.economicDepartment = value;
    }

}
