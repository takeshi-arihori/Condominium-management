package model;
/**
 * DTO (Data Transfer Object)
 * @author student10
 *
 */
public class Apartment {
	private int room_no;
	private String rsd_name;
	private int household_size;
	private String date;
	
	/**
	 * @param room_no
	 * @param rsd_name
	 * @param household_size
	 * @param date
	 */
	public Apartment(int room_no, String rsd_name, int household_size, String date) {
		setRoom_no(room_no);
		setRsd_name(rsd_name);
		setHousehold_size(household_size);
		setDate(date);
	}
	
	/**
	 * @return room_no
	 */
	public int getRoom_no() {
		return room_no;
	}
	/**
	 * @return rsd_name
	 */
	public String getRsd_name() {
		return rsd_name;
	}
	/**
	 * @return household_size
	 */
	public int getHousehold_size() {
		return household_size;
	}
	/**
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	
	
	/**
	 * @param room_no セットする room_no
	 */
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	/**
	 * @param rsd_name セットする rsd_name
	 */
	public void setRsd_name(String rsd_name) {
		this.rsd_name = rsd_name;
	}
	/**
	 * @param household_size セットする household_size
	 */
	public void setHousehold_size(int household_size) {
		this.household_size = household_size;
	}
	/**
	 * @param date セットする date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public void display() {
		System.out.println();
		System.out.println("部屋番号: " + getRoom_no());
		System.out.println("契約者名: " + getRsd_name());
		System.out.println("世帯人数: " + getHousehold_size());;
		System.out.println("入居日付: " + getDate());
		System.out.println();
	}
	
	
}
