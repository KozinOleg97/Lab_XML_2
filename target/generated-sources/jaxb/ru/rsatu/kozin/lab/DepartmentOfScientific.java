//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.27 at 03:58:59 PM MSK 
//


package ru.rsatu.kozin.lab;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for departmentOfScientific complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="departmentOfScientific"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://lab.kozin.rsatu.ru/}department"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="library" type="{http://lab.kozin.rsatu.ru/}library"/&gt;
 *         &lt;element name="educationalMethodicalDepartment" type="{http://lab.kozin.rsatu.ru/}department"/&gt;
 *         &lt;element name="faculty" type="{http://lab.kozin.rsatu.ru/}faculty" maxOccurs="50" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "departmentOfScientific", propOrder = {
    "library",
    "educationalMethodicalDepartment",
    "faculty"
})
public class DepartmentOfScientific
    extends Department
{

    @XmlElement(required = true)
    protected Library library;
    @XmlElement(required = true)
    protected Department educationalMethodicalDepartment;
    @XmlElement(required = true)
    protected List<Faculty> faculty;

    /**
     * Gets the value of the library property.
     * 
     * @return
     *     possible object is
     *     {@link Library }
     *     
     */
    public Library getLibrary() {
        return library;
    }

    /**
     * Sets the value of the library property.
     * 
     * @param value
     *     allowed object is
     *     {@link Library }
     *     
     */
    public void setLibrary(Library value) {
        this.library = value;
    }

    /**
     * Gets the value of the educationalMethodicalDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link Department }
     *     
     */
    public Department getEducationalMethodicalDepartment() {
        return educationalMethodicalDepartment;
    }

    /**
     * Sets the value of the educationalMethodicalDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Department }
     *     
     */
    public void setEducationalMethodicalDepartment(Department value) {
        this.educationalMethodicalDepartment = value;
    }

    /**
     * Gets the value of the faculty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faculty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaculty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Faculty }
     * 
     * 
     */
    public List<Faculty> getFaculty() {
        if (faculty == null) {
            faculty = new ArrayList<Faculty>();
        }
        return this.faculty;
    }

}