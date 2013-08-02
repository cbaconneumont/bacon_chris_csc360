
package edu.neumont.csc380.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for lunch complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lunch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resturant" type="{}resturant" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement
@XmlType(name = "lunch", propOrder = {
        "restaurant"
})
public class Lunch {

    @XmlElement(name="restaurant")
    protected List<Restaurant> restaurant;

    /**
     * Gets the value of the resturant property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resturant property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResturant().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Restaurant }
     *
     *
     */
    public List<Restaurant> getRestaurant() {
        if (restaurant == null) {
            restaurant = new ArrayList<Restaurant>();
        }
        return this.restaurant;
    }


    /**
     * CODE THAT SHOWS HOW THIS SHIT WORKS
     *
     * //initialize the object factory
     * //initialize objects, give them values
     */
    public void oewhfroiuew() throws JAXBException, FileNotFoundException {
     ObjectFactory of = new ObjectFactory();
     Menuitem item1 = of.createMenuitem();
     Menuitem item2 = of.createMenuitem();

     item1.setName("Pork");
     item1.setPrice(12.99);                 1
     item2.setName("Steak");
     item2.setPrice(15.99);

     Restaurant rest = of.createResturant();
     rest.setName("Lamb's Grill");
     rest.setAddress("123 fake st");
     rest.getMenuitem().add(item1);
     rest.getMenuitem().add(item2);

     Lunch l = of.createLunch();
     l.getRestaurant().add(rest);

     //get a new instance of jaxbcontext using the correct package name
     JAXBContext jax = JAXBContext.newInstance("edu.neumont.csc380.model");

     //marshal this shit to whatever xml file
     Marshaller m = jax.createMarshaller();
     m.marshal(l, new FileOutputStream("baconthing2.xml"));

     //when you want to unmarshal, use a jaxb thing and unmarshal it by casting
     Unmarshaller um = jax.createUnmarshaller();
     Lunch lunch = (Lunch) um.unmarshal(new File("baconthing2.xml"));

     System.out.println(lunch.getRestaurant().size());
    }

}
