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


@WebServlet(urlPatterns={"/delete_selected_result_controller"})

public class Delete_selected_result_controller extends HttpServlet {
    
    protected void doPost( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	response.setContentType("text/html; charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
    	
    	
    	try {
    		int result_status = 0;
    		// 削除したリストを格納(削除前に取得し格納)
    		ArrayList<Apartment>deleteLists = new ArrayList<>();
    		
    		// 削除したいroom numberをチェックリストで取得
            String[] checkedDeleteLists = request.getParameterValues("checkbox");
            
            if (checkedDeleteLists != null){
	            for (String room_no : checkedDeleteLists){
	            	// 削除するリストをArrayListに格納
	            	Apartment tempListApartment = Dao_Apartment.roomNumberSearch(room_no);
	            	deleteLists.add(tempListApartment);
	            	
	            	// 削除したリストがresult_statusにカウントされる
	            	result_status += Dao_Apartment.deleteContract(room_no);
	            }
            }else {
            	// 中身がnullなら
            	result_status = -999;
            }

    		// ステータス番号を保存
    		request.setAttribute("result_status", result_status);
    		
    		// 削除する前に保存したApartment(ArrayListに格納)
    		request.setAttribute("deleteLists", deleteLists);
    		
    		// 検索結果画面に繊維
    		request.getRequestDispatcher("result_select_delete.jsp").forward(request, response);

    	} catch(Exception e) {
        	PrintWriter out = response.getWriter();
    		out.println("Room_select_controller System Error");
    		out.println(e);
    	}

    }

}
