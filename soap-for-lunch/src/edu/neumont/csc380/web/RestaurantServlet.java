package edu.neumont.csc380.web;

import com.sun.xml.internal.ws.resources.ModelerMessages;
import edu.neumont.csc380.soapRequest.Envelope;
import edu.neumont.csc380.soapResponse.Body;
import edu.neumont.csc380.soapResponse.GetRestaurantsResponse;
import edu.neumont.csc380.soapResponse.ObjectFactory;
import edu.neumont.csc380.soapResponse.Restaurant;

import javax.servlet.annotation.WebServlet;
import javax.xml.bind.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: cbacon
 * Date: 7/31/13
 * Time: 6:53 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/zack")
public class RestaurantServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {


            JAXBContext jbc = JAXBContext.newInstance("edu.neumont.csc380.soapRequest");
            Unmarshaller um = jbc.createUnmarshaller(); //get unmarshaller
            InputStream inputStream = request.getInputStream();
            edu.neumont.csc380.soapRequest.Envelope soapRequestEnvelope
                    = (edu.neumont.csc380.soapRequest.Envelope) um.unmarshal(inputStream);

            JAXBContext jbcResp = JAXBContext.newInstance("edu.neumont.csc380.soapResponse");

            Marshaller m = jbcResp.createMarshaller();

            edu.neumont.csc380.soapResponse.ObjectFactory of = new edu.neumont.csc380.soapResponse.ObjectFactory();
            edu.neumont.csc380.soapResponse.Envelope soapResponseEnvelope
                    = of.createEnvelope();
            edu.neumont.csc380.soapResponse.Restaurant r = of.createRestaurant();
            r.setName("Lamb's Grill");
            edu.neumont.csc380.soapResponse.Body body = of.createBody();
            edu.neumont.csc380.soapResponse.GetRestaurantsResponse resp = of.createGetRestaurantsResponse();
            resp.setRestaurant(r);
            soapResponseEnvelope.setBody(body);

            OutputStream stream = response.getOutputStream();
            m.marshal(soapResponseEnvelope, stream);

            return;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.getWriter().write("Order successful");


    }
}
