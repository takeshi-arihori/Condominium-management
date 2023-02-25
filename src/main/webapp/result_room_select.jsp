<%@page import="model.Apartment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Result Room Number Search</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Result Room Number Search</h1>
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
	    	Apartment contractor = (Apartment) request.getAttribute("con");
	    	
	    	if(contractor == null) {
	    %>
	    		<p>該当する部屋番号の情報はありません。</p>
	    <%	    	
	    	}else{
	   	%>

		    <tr>
			    <td><%= contractor.getRoom_no() %></td>
			    <td><%= contractor.getRsd_name() %></td>
			    <td><%= contractor.getHousehold_size() %></td>
			    <td><%= contractor.getDate() %></td>
		    </tr>
		    
		<%
	    	}
		%>

    </table>
    <p>
        <a href="top.jsp">Top画面に戻る</a>
    </p>

</body>
</html>