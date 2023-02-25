<%@page import="model.Apartment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result All Select Display</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Result Apartment All Select List</h1>
    <hr>
    
    <table>
    
	   	<tr>
	    	<th>部屋番号</th>
	    	<th>氏名</th>
	    	<th>世帯数</th>
	    	<th>入居日</th>
	    </tr>
    

	    <%
	    	request.setCharacterEncoding("UTF-8");
	    	ArrayList<Apartment> list = (ArrayList<Apartment>) request.getAttribute("list");
	    	
	    	for(Apartment a : list){
	    		if(a == null) {
	    %>
	    			<p>該当する名前の情報は存在しません。</p>
	    <%
	    		}else{
	    %>
		    	    
				    <tr>
					    <td><%= a.getRoom_no() %></td>
					    <td><%= a.getRsd_name() %></td>
					    <td><%= a.getHousehold_size() %></td>
					    <td><%= a.getDate() %></td>
				    </tr>

	    
	    <%
		    	}
	    	}
	    %>

    </table>
    <p>
        <a href="top.jsp">Top画面に戻る</a>
    </p>

</body>
</html>