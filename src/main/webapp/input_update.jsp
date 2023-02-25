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
    <link rel="stylesheet" href="style.css">
</head>

<body>
    
	    <%
	    	request.setCharacterEncoding("UTF-8");
	    	int result_status = (int) request.getAttribute("result_status");
	    	Apartment apartment = (Apartment) request.getAttribute("apartment");
	    	String room_no = (String) session.getAttribute("room_no");

	   		if(result_status == -999){
	   	%>
	   			<p>入力された部屋番号には入居者が存在しません！！</p>
	   			<p>処理を中断します！！</p>
	   	<%	   			
	   		}else{
	   	%>
		    <h1>Check If You Can Update OK!!</h1>
		    <hr>
	   		<p>以下の部屋番号の情報を更新します！！</p>
	   		
			<p><%= apartment.getRoom_no() %>号室</p>
	
    		
			<br>
   			<hr>
   			
		   	<p>更新したい内容を入力してください</p>
		   	
		   		<form action="update_controller" method="post">
	                <p>
	                    <label for="name">名前:
	                        <input type="text" name="name" value="<%=apartment.getRsd_name() %>">
	                    </label>
	                </p>
	                <p>
	                    <label for="household_size">世帯数:
	                        <input type="number" name="size" value="<%= apartment.getHousehold_size() %>">
	                    </label>
	                </p>
	                <p>
	                    <label for="date">入居日:
	                        <input type="date" name="date" value="<%= apartment.getDate() %>">
	                    </label>
	                </p>
	
	                <button type="submit" onClick="window.alert('更新します！！')">更新</button>
	            </form>
	   	<%
	   		}
	   	%>	
	   	
	   	

    <p>
        <a href="top.jsp">Top画面に戻る</a>
    </p>

</body>
</html>