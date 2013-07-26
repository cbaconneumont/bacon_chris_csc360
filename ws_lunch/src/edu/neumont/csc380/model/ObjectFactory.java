
package edu.neumont.csc380.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.neumont.csc380.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Lunch_QNAME = new QName("", "lunch");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.neumont.csc380.model
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Lunch }
     *
     */
    public Lunch createLunch() {
        return new Lunch();
    }

    /**
     * Create an instance of {@link Restaurant }
     *
     */
    public Restaurant createResturant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link Menuitem }
     *
     */
    public Menuitem createMenuitem() {
        return new Menuitem();
    }


}
