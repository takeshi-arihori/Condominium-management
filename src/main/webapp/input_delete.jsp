<%@page import="model.Apartment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Check Update Room Number</title>
    <link rel="stylesheet" href="delete.css">
</head>

<body>
    
	    <%
	    	request.setCharacterEncoding("UTF-8");
	    	int result_status = (int) request.getAttribute("result_status");
	    	
	    	Apartment apartment = (Apartment) session.getAttribute("apartment");
	    	String room_no = (String) session.getAttribute("room_no");

	   		if(result_status == -999){
	   	%>
	   			<p>入力された部屋番号<%=room_no %>号室には入居者が存在しません！！</p>
	   			<p>処理を中断します！！</p>
	   	<%	   			
	   		}else{
	   	%>
		    <h1>Check If You Can Delete OK??</h1>
		    <hr>
	   		<p>以下の部屋番号の情報を削除します！！</p>
		    
		    <table>
			    <tr>
			    	<th>部屋番号</th>
			    	<th>氏名</th>
			    	<th>世帯数</th>
			    	<th>入居日</th>
			    </tr>
	
			    <tr>
				    <td><%= apartment.getRoom_no() %></td>
				    <td><%= apartment.getRsd_name() %></td>
				    <td><%= apartment.getHousehold_size() %></td>
				    <td><%= apartment.getDate() %></td>
			    </tr>
	
	    	</table>
	    	
	    	<br>
	    	<hr>
	    	
	   		<p>削除してもよろしいですか？？</p>
	   		
	   		<form action="delete_controller" method="post">
		   		<button type="submit" class="styled">Delete</button>
	   		</form>
	   		
	   	<%
	   		}
	   	%>	
	   	
	   	

    <p>
        <a href="top.jsp">Top画面に戻る</a>
    </p>

</body>
</html>