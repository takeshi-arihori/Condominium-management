<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Apartment Search System</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h1>Apartment Search System</h1>
    <hr>
    
    <!-- 全件検索 -->
    <h3>全件検索</h3>
    <p>
        <a href="all_select_controller">全件検索</a>
    </p>
    
    <br>
    <hr>
    
    <!-- 部屋番号検索 -->
    <h3>部屋番号検索します</h3>
    <form action="room_select_controller" method="get">
	    <p>
	    	<label for="room_no">検索したい部屋番号を入力してください: <br>
	    		<input type="number" name="room_no" min="101" max="1600">
	    	</label>
	    	<button type="submit">Search</button> 
	    </p>
    </form>
    
    <br>
    <hr>
    
    <!-- 名前検索 -->
    <h3>名前検索します</h3>
    <form action="name_select_controller" method="get">
	    <p>
	    	<label for="name">検索したい名前を入力してください: <br>
	    		<input type="text" name="name">
	    	</label>
	    	<button type="submit">Search</button>
	    </p>
    </form>
    
    <br>
    <hr>
    
    <!-- 新規登録 -->
    
    <h3>新規登録</h3>
    
    <div class="wrap2">
	    <form action="insert_controller" method="post">
	    
	    <p>
	        <label for="room_no">部屋番号: 
	            <input type="number" name="room_no">
	        </label>
	    </p>
	    <p>
	        <label for="name">名前: 
	            <input type="text" name="name">
	        </label>
	    </p>
	    <p>
	        <label for="household_size">世帯数: 
	            <input type="number" name="size">
	        </label>
	    </p>
	    <p>
	        <label for="date">入居日: 
	            <input type="date" name="date" value="2023-01-01">
	        </label>
	    </p>
	
	    <button type="submit" onClick="window.alert('新規登録進めます')">新規登録</button>
		</form>
    </div>
    
    <br>
    <hr>
    
    <!-- 契約者更新 -->
    <h3>契約者情報を更新します</h3>
    <div class="wrap3">
         <form action="input_update_controller" method="post">
             <p>
                 <label for="room">更新したい部屋番号を入力してください: <br>
                     <input type="number" name="room_no" id="room">
                 </label>
                 <button type="submit" onClick="window.alert('更新できるか確認します')">更新</button>
             </p>
         </form>
    </div>
    
    <br>
    <hr>
    
    
    <!-- 契約情報削除 -->
    <h3>契約者情報を削除します</h3>
    <div class="wrap4">
        <form action="delete_confirm_controller" method="post">
            <p>
                <label for="delete">削除したい部屋番号を入力してください: <br>
                    <input type="number" name="room_no" id="delete">
                </label>
                <button type="submit" onClick="window.alert('削除できるか確認します')">更新</button>
            </p>
        </form>
    </div>
    
    <br>
    <hr>
    
    <!-- 契約情報削除(複数選択ver) -->
    <h3>複数件の契約者情報を削除します</h3>
    <div class="wrap5">
    	<p>
    		<a href="delete_selected_confirm_controller">複数の削除希望</a>
    	</p>
    </div>


</body>
</html>