package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * DAO (Data Access Object)
 * @author student10
 *
 */
public class Dao_Apartment {
	// 各メソッドと共有できるようにメンバー変数に
	private static String url = "jdbc:h2:tcp://localhost/~/mydb";
	private static String userName = "sa";
	private static String password = "student10";
	
	
	/**
	 * 1, 全件表示
	 * @return
	 */
	public static ArrayList<Apartment> all_select(){
		
		ArrayList<Apartment> list = new ArrayList<>();
		String sql = "SELECT * FROM APARTMENT ORDER BY room_no ASC";
		
		try(
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement(sql);
		){
			System.out.println("データベースへの接続が成功しました。");

			// SQL文の送信
			ResultSet rs = ps.executeQuery();
			
			// ResultSetでの処理をArrayListに格納
			while(rs.next()) {
				int no = rs.getInt("room_no");
				String name = rs.getString("rsd_name");
				int size = rs.getInt("household_size");
				String cont = rs.getString("contact_date");
				
				Apartment apartment = new Apartment(no, name, size, cont);
				list.add(apartment);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			System.out.println("データベースへの接続を切断しました。");
		}
		
		return list;
	}
	

	/**
	 * 2, 部屋番号検索
	 * キーボード入力で号室番号を入力してもらい、引数として渡す
	 * @param input
	 * @return
	 */
	public static Apartment roomNumberSearch(String input) {
		
		String sql = "SELECT * FROM APARTMENT WHERE ROOM_NO like ?";
		
		// APARTMENT型を初期化
		Apartment apartment = null;
		
		try(
				Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement(sql);
		){
			System.out.println("データベースへの接続が成功しました。");
			
			// ここに処理を書く
			// 変数apartmentの中に、DBから受け取った情報を詰め込む
			ps.setString(1, input);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int no = rs.getInt("room_no");
				String name = rs.getString("rsd_name");
				int size = rs.getInt("household_size");
				String cont = rs.getString("contact_date");
				apartment = new Apartment(no, name, size, cont);
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			System.out.println("データベースへの接続を切断しました。");
		}
		return apartment;
	}
	
	
	
	/**
	 * 	3, 契約者名検索
	 * 検索したい名前を受け取り、該当する名義人の情報をArrayListで返す
	 * @param input
	 * @return ArrayList
	 */
	public static ArrayList<Apartment> contractorNameSearch(String input) {
		ArrayList<Apartment> list = new ArrayList<>();
		
		String sql = "SELECT * FROM APARTMENT WHERE RSD_NAME like ?";
		
		
		try(
				Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement(sql);
			){
				System.out.println("データベースへの接続が成功しました。");

				ps.setString(1, "%" +input + "%");
				// SQL文の送信
				ResultSet rs = ps.executeQuery();
				
				// ResultSetでの処理をArrayListに格納
				while(rs.next()) {
					int no = rs.getInt("room_no");
					String name = rs.getString("rsd_name");
					int size = rs.getInt("household_size");
					String cont = rs.getString("contact_date");
					
					Apartment apartment = new Apartment(no, name, size, cont);
					list.add(apartment);
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				System.out.println("データベースへの接続を切断しました。");
			}
		
		return list;
	}
	
	
	/**
	 * 4, 登録情報一括更新
	 * 更新するデータを受け取り、更新結果をint型で返す
	 * @param num
	 * @param name
	 * @param hhs
	 * @param date
	 * @return int
	 */
	public static int update_bulk(String num, 
								  String name, 
								  String hhs, 
								  String date) {
		
		int count = 0;
		String sql = "UPDATE APARTMENT SET rsd_name = ?, household_size = ?, contact_date = ? WHERE room_no = ? ";
		
		
		try(
				Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement(sql);
			){
				System.out.println("データベースへの接続が成功しました。");

				ps.setString(1, name);
				ps.setString(2, hhs);
				ps.setString(3, date);
				ps.setString(4, num);
				
				count = ps.executeUpdate();
				
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				System.out.println("データベースへの接続を切断しました。");
			}
		
		return count;
	}
	
	
	
	/**
	 * 5 登録情報一部更新
	 * @return int
	 */
	public static int partial_update(String room_no, String update_column, String update_value) {

		int count = 0;
		String sql = "UPDATE APARTMENT SET " + update_column + " = ? WHERE room_no = ?";

		
		try(
				Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement(sql);
			){
				System.out.println("データベースへの接続が成功しました。");

				ps.setString(1, update_value);
				ps.setString(2, room_no);
				
				count = ps.executeUpdate();
				
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				System.out.println("データベースへの接続を切断しました。");
			}
		
		return count;
	}
	

	
	/**
	 * 6, 新規登録
	 * @param num
	 * @param name
	 * @param hhs
	 * @param date
	 * @return
	 */
	public static int newInsert(String num, 
			  					String name, 
			  					String hhs, 
			  					String date) {
		int resultInt = 0;
		String sql = "INSERT INTO apartment VALUES (?, ?, ?, ?)";
		
		
		try(
				Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement(sql);
			){
				System.out.println("データベースへの接続が成功しました。");

				ps.setString(1, num);
				ps.setString(2, name);
				ps.setString(3, hhs);
				ps.setString(4, date);
				
				resultInt = ps.executeUpdate();
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				System.out.println("データベースへの接続を切断しました。");
			}
		
		return resultInt;
	}
	
	
	/**
	 * 登録情報削除
	 * @param room_no
	 * @return
	 */
	public static int deleteContract(String room_no) {
		// 削除の結果を代入
		int resultInt = 0;
		
		String sql = "DELETE FROM apartment WHERE room_no = ?";
		
		
		try(
				Connection con = DriverManager.getConnection(url, userName, password);
				PreparedStatement ps = con.prepareStatement(sql);
			){
				System.out.println("データベースへの接続が成功しました。");

				ps.setString(1, room_no);
				
				resultInt = ps.executeUpdate();
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				System.out.println("データベースへの接続を切断しました。");
			}
		
		
		
		return resultInt;
	}
	
}
