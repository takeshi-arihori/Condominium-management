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


@WebServlet(urlPatterns={"/delete_confirm_controller"})

public class Delete_confirm_controller extends HttpServlet {
    
    protected void doPost( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	response.setContentType("text/html; charset=utf-8");
    	request.setCharacterEncoding("UTF-8");

    	

    	
    	try {

    		// 判定のための変数( true: 0 || false: -999 )
    		int result_status = 0;
    		
    		String input = request.getParameter("room_no");
    		
    		// 該当の部屋番号に入居者が存在するかチェックするためにEntityから情報を取得
    		Apartment apartment = Dao_Apartment.roomNumberSearch(input);
    		
    		// その部屋番号に入居者が存在しない場合
    		// ステータス変数にエラーコード(-999)を入れる。
    		if(apartment == null) {
    			result_status = -999;
    		} 
    		
    		request.setAttribute("result_status", result_status);
    		
    		// 次のControllerに受け取ったroom_noを使用するためsessionで保存
    		HttpSession session = request.getSession();
    		session.setAttribute("room_no", input);
    		
    		// 最後の画面で削除した情報を表示するためsessionに保存
    		session.setAttribute("apartment", apartment);
    		
    		request.getRequestDispatcher("input_delete.jsp").forward(request, response);

    	} catch(Exception e) {
        	PrintWriter out = response.getWriter();
    		out.println("Input_update_controller System Error");
    		out.println(e);
    	}

	}

}