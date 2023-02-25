package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Apartment;
import model.Dao_Apartment;


@WebServlet(urlPatterns={"/room_select_controller"})

public class Room_select_controller extends HttpServlet {
    
    protected void doGet( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	
    	try {
    		// jspから入力された部屋番号を受け取る
    		String input = request.getParameter("room_no");
    		// 正規表現で入力された部屋番号をチェック
    		boolean checkInput = input.matches("[0-9]{3,4}");
    		// 部屋番号が正しい数値なら処理を行う
    		if(checkInput) {
    			// Daoから部屋番号に紐づいている契約者情報を取得
    			Apartment contractor = Dao_Apartment.roomNumberSearch(input);
    			// request scopeに保存
    			request.setAttribute("con", contractor);
    			// forwardする
    			request.getRequestDispatcher("result_room_select.jsp").forward(request, response);
    		}
    		else {
    			System.out.println("正しい部屋番号を入力して下さい！！");	
    		}
    	} catch(Exception e) {
    		PrintWriter out = response.getWriter();
    		out.println("Room_select_controller System Error");
    		out.println(e);
    	}

	}

}