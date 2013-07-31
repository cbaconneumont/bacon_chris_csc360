package edu.neumont.csc380.controller;

import edu.neumont.csc380.Driver;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 7/23/13
 * Time: 7:10 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/Restaurant")
public class RestaurantServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher disp = getServletContext().getRequestDispatcher("/index.jsp");
        disp.forward(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{

    }

    protected  void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }
}
