<%@page import="model.Apartment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checked It Can Update Room Number</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Result Insert Resident Status</h1>
    <hr>
    <p>更新情報結果</p>
    
    
    
	    <%
	    	request.setCharacterEncoding("UTF-8");
	    	int result_status = (int) request.getAttribute("result_status");
	    	Apartment apa = (Apartment) request.getAttribute("updatedApartment");
	    	
	    	if(result_status == 0){
	   	%>
	   			<p>更新できませんでした！！</p>
	   			<p>処理を中断します！！</p>
	   	<%	    		
	    	}else if(result_status >= 2){
	   	%>
	   			<p>予期せぬエラーが発生しました。</p>
	   			<p>早急にサーバー担当者に連絡してください！！</p>
	   			<p>サーバー担当者直通ダイヤル: 080-1234-5678</p>
	    	
	    <%
	    	}else{
	    %>	
	    
		    <table>
		    
			    <tr>
			    	<th>部屋番号</th>
			    	<th>氏名</th>
			    	<th>世帯数</th>
			    	<th>入居日</th>
			    </tr>
	
			    <tr>
				    <td><%= apa.getRoom_no() %></td>
				    <td><%= apa.getRsd_name() %></td>
				    <td><%= apa.getHousehold_size() %></td>
				    <td><%= apa.getDate() %></td>
			    </tr>
	
	    	</table>
	    	
	    	
	    <%
	    	}
	    %>	
    	
    <p>
        <a href="top.jsp">Top画面に戻る</a>
    </p>

</body>
</html>