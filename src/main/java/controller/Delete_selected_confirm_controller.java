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


@WebServlet(urlPatterns={"/delete_selected_confirm_controller"})

public class Delete_selected_confirm_controller extends HttpServlet {
    
    protected void doGet( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	response.setContentType("text/html; charset=utf-8");
    	request.setCharacterEncoding("UTF-8");


        	try {
        		int result_status = 0;
        		// Dao内にあるall_selectメソッドを呼び出し、戻り値はArrayList <Entity> となる
        		// 取得したリスト全員分のデータ
        		ArrayList<Apartment> list = Dao_Apartment.all_select();
        		
        		// listが空なら異常値を記す数値を代入
        		if(list == null) {
        			result_status = -999;
        		}
        		
        		request.setAttribute("list", list);
        		request.setAttribute("result_status", result_status);
        		// 検索結果画面に繊維
        		request.getRequestDispatcher("select_delete.jsp").forward(request, response);
        	} catch(Exception e) {
        		PrintWriter out = response.getWriter();
        		out.println("All_select_controller System Error");
        		out.println(e);
        	}

	}

}