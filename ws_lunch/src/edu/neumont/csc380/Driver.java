package edu.neumont.csc380;

import edu.neumont.csc380.model.Lunch;
import edu.neumont.csc380.model.Menuitem;
import edu.neumont.csc380.model.ObjectFactory;
import edu.neumont.csc380.model.Restaurant;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 7/26/13
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {
    ObjectFactory of;
    public Menuitem item1;
    public Menuitem item2;
    public Restaurant rest;
    public Lunch lunch;

    public Driver(){
        of = new ObjectFactory();
        item1 = of.createMenuitem();
        item2 = of.createMenuitem();
        rest = of.createResturant();

        setMenuItems();
        setRestaurants();

        Lunch l = of.createLunch();
        l.getRestaurant().add(rest);

        //get a new instance of jaxbcontext using the correct package name
        JAXBContext jax = null;
        try {
            jax = JAXBContext.newInstance("edu.neumont.csc380.model");
            //marshal this shit to whatever xml file
            Marshaller m = jax.createMarshaller();
            m.marshal(l, new FileOutputStream("baconthing2.xml"));

            //when you want to unmarshal, use a jaxb thing and unmarshal it by casting
            Unmarshaller um = jax.createUnmarshaller();
            lunch = (Lunch) um.unmarshal(new File("baconthing2.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(l.getRestaurant().size());
    }

    private void setMenuItems(){
        item1.setName("Pork");
        item1.setPrice(12.99);
        item2.setName("Steak");
        item2.setPrice(15.99);
    }

    private void setRestaurants(){
        rest.setName("Lamb's Grill");
        rest.setAddress("123 fake st");
        rest.getMenuitem().add(item1);
        rest.getMenuitem().add(item2);
    }
}
