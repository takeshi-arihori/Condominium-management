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


@WebServlet(urlPatterns={"/insert_controller"})

public class Insert_controller extends HttpServlet {
    
    protected void doPost( HttpServletRequest request , HttpServletResponse response )
    throws ServletException , IOException {
    	
    	response.setContentType("text/html; charset=utf-8");
    	request.setCharacterEncoding("UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	
    	// insert文は戻り値はint型
    	
    	// 1: 該当の号室にすでに入居者がいる場合。
    	// Insert分は実行しない。
    	
    	// 2: 該当の号室は空部屋である場合。
    	// insert文を実行する
    	
    	
    	//・戻り値が「0」の場合。失敗！！
    	//・戻り値が「1」の場合。成功！！
    	//・戻り値が「2」以上の場合。失敗！！
   
    	
    	// 判定のための変数
    	int result_status = 0;
    	
    	try {
    		// jspから入力された新規登録者の情報を受け取る
    		String room_no = request.getParameter("room_no");
    		String name = request.getParameter("name");
    		String size = request.getParameter("size");
    		String date = request.getParameter("date");
    		
    		// 該当の部屋番号に入居者が存在するかチェックするために検索をかける
    		Apartment apartment = Dao_Apartment.roomNumberSearch("room_no");
    		
    		// その部屋番号に入居者が存在する場合
    		// ステータス変数にエラーコード(-999)を入れる。
    		// 入居者がいない場合は新規登録をする。
    		if(apartment != null) {
    			result_status = -999;
    		} else {
    			// 入居者がいないことを確認できたらformから受け取った情報をDaoに渡す
    			result_status = Dao_Apartment.newInsert(room_no, name, size, date);
    		}
    		
    		
    		out.println("<html>");
    		out.println("<head>");
    		out.println("<title>" + "検索結果" + "</title>");
    		out.println("</head>");
    		out.println("<body>");
    		
    		// result_status番号結果で判定分け
	    	if(result_status >= 2) {
	    			out.println("<p>新規登録に失敗しました。</p>");
	    			out.println("<p>予期せぬ事態が生じました。</p>");
	    			out.println("<p>新規登録に失敗しました。</p>");
	    		
	    	}else if(result_status == 0){
	    		out.println("");
	    		out.println("<p>新規登録に失敗しました。</p>");
	    		out.println("<p>既に登録者が存在するようです。</p>");
	    		out.println("");
	    		
    		out.println("</body>");
    		out.println("</html>");
    		
	    	}else{
	    		// 今登録したばかりの契約者のデータを取得
	    		Apartment resident = Dao_Apartment.roomNumberSearch(room_no);
	    		// ステータス番号を保存
	    		request.setAttribute("resident", resident);
	    		// 検索結果画面に繊維
	    		request.getRequestDispatcher("result_insert.jsp").forward(request, response);
	    	}

    	} catch(Exception e) {
    		out.println("Room_select_controller System Error");
    		out.println(e);
    	}

    }

}
