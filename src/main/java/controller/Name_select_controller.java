package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Apartment;
import model.Dao_Apartment;


@WebServlet(urlPatterns={"/name_select_controller"})

public class Name_select_controller extends HttpServlet {
    
    protected void doGet( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	
    	try {
    		String input = request.getParameter("name");
    		ArrayList<Apartment>list = Dao_Apartment.contractorNameSearch(input);
    		request.setAttribute("list", list);
    		request.getRequestDispatcher("result_name_select.jsp").forward(request, response);
    	} catch(Exception e) {
    		PrintWriter out = response.getWriter();
    		out.println("Room_select_controller System Error");
    		out.println(e);
    	}

	}

}