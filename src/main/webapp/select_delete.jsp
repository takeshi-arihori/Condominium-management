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
	    	ArrayList<Apartment> list = (ArrayList<Apartment>) request.getAttribute("list");
	    	int result_status = (int)request.getAttribute("result_status");
	    	

	   		if(result_status == -999){
	   	%>
	   			<p>入居者が存在しません！！</p>
	   			<p>処理を中断します！！</p>
	   	<%	   			
	   		}else{
	   	%>
		    <h1>Please check the list you want to delete!!</h1>
		    <hr>
	   		<h2>Apartment List</h2>
	   		
		    <table>
			    <tr>
			    	<th></th>
			    	<th>部屋番号</th>
			    	<th>氏名</th>
			    	<th>世帯数</th>
			    	<th>入居日</th>
			    </tr>
	
	   		<form action="delete_selected_result_controller" method="post">
	   	<%
	   			for(Apartment apa : list) {
	   	%>
			    <tr>
			    	<td><input type="checkbox" name="checkbox" value="<%=apa.getRoom_no() %>"></td>
				    <td><%= apa.getRoom_no() %></td>
				    <td><%= apa.getRsd_name() %></td>
				    <td><%= apa.getHousehold_size() %></td>
				    <td><%= apa.getDate() %></td>
			    </tr>
	   	<%
	   			}
	   	%>
		   		<button type="submit" class="styled">Delete</button>
	   		</form>
	   		
	    	</table>
	    	
	    	<br>
	    	<hr>
		    	
	   		
	   		
	   	<%
	   		}
	   	%>	
	   	
	   	

    <p>
        <a href="top.jsp">Top画面に戻る</a>
    </p>

</body>
</html>