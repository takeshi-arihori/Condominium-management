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


@WebServlet(urlPatterns={"/input_update_controller"})

public class Input_update_controller extends HttpServlet {
    
    protected void doPost( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	response.setContentType("text/html; charset=utf-8");
    	request.setCharacterEncoding("UTF-8");

    	

    	// 判定のための変数
    	int result_status = 0;
    	
    	try {

    		String input = request.getParameter("room_no");
    		
    		// 該当の部屋番号に入居者が存在するかチェックするために検索をかける
    		Apartment apartment = Dao_Apartment.roomNumberSearch(input);
    		
    		// その部屋番号に入居者が存在しない場合
    		// ステータス変数にエラーコード(-999)を入れる。
    		if(apartment == null) {
    			result_status = -999;
    		} 
    		
    		request.setAttribute("result_status", result_status);
    		request.setAttribute("apartment", apartment);
    		
    		// 次のControllerに受け取ったroom_noを使用するためsessionで保存
    		HttpSession session = request.getSession();
    		session.setAttribute("room_no", input);
    		
    		request.getRequestDispatcher("input_update.jsp").forward(request, response);

    	} catch(Exception e) {
        	PrintWriter out = response.getWriter();
    		out.println("Input_update_controller System Error");
    		out.println(e);
    	}

	}

}