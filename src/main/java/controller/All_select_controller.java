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


@WebServlet(urlPatterns={"/all_select_controller"})

public class All_select_controller extends HttpServlet {
    
    protected void doGet( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	
    	try {
    		// Dao内にあるall_selectメソッドを呼び出し、戻り値はArrayList <Entity> となる
    		ArrayList<Apartment> list = Dao_Apartment.all_select();
    		// 取得したリスト全員分のデータ
    		request.setAttribute("list", list);
    		// 検索結果画面に繊維
    		request.getRequestDispatcher("result_all_select.jsp").forward(request, response);
    	} catch(Exception e) {
    		PrintWriter out = response.getWriter();
    		out.println("All_select_controller System Error");
    		out.println(e);
    	}

	}

}