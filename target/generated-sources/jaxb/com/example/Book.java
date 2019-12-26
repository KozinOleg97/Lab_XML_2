//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.12.26 at 08:48:19 AM MSK 
//


package com.example;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for book complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="book"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence maxOccurs="unbounded" minOccurs="10"&gt;
 *         &lt;element name="bookID" type="{http://example.com/}id"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "book", propOrder = {
    "bookIDAndTitleAndState"
})
public class Book {

    @XmlElements({
        @XmlElement(name = "bookID", required = true, type = BigInteger.class),
        @XmlElement(name = "title", required = true, type = String.class),
        @XmlElement(name = "state", required = true, type = Boolean.class)
    })
    protected List<Serializable> bookIDAndTitleAndState;

    /**
     * Gets the value of the bookIDAndTitleAndState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bookIDAndTitleAndState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBookIDAndTitleAndState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BigInteger }
     * {@link String }
     * {@link Boolean }
     * 
     * 
     */
    public List<Serializable> getBookIDAndTitleAndState() {
        if (bookIDAndTitleAndState == null) {
            bookIDAndTitleAndState = new ArrayList<Serializable>();
        }
        return this.bookIDAndTitleAndState;
    }

}
