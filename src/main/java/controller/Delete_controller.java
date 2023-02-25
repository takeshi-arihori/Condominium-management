package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Apartment;
import model.Dao_Apartment;


@WebServlet(urlPatterns={"/delete_controller"})

public class Delete_controller extends HttpServlet {
    
    protected void doPost( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	response.setContentType("text/html; charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	try {
    		
    		HttpSession session = request.getSession();
    		
    		String room_no = (String)session.getAttribute("room_no");
    		// 削除した情報を最後に出力するためsessionに保存
    		Apartment apa = (Apartment)session.getAttribute("apartment");

    		
    		// DAOに受けとった更新情報を渡して更新
    		int result_status = Dao_Apartment.deleteContract(room_no);
    		

    		// ステータス番号を保存
    		request.setAttribute("result_status", result_status);
    		
    		// 削除する前に保存したApartment
    		request.setAttribute("deletedApartment", apa);
    		
    		// 検索結果画面に繊維
    		request.getRequestDispatcher("result_delete.jsp").forward(request, response);

    	} catch(Exception e) {
        	PrintWriter out = response.getWriter();
    		out.println("Room_select_controller System Error");
    		out.println(e);
    	}

    }

}
