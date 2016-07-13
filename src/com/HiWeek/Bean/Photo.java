package com.HiWeek.Bean;

public class Photo {
	private int p_id; 
	private String p_photo;
	private int a_id; 
	private int p_sign; 

	public Photo(int p_id, String p_photo, int a_id, int p_sign) {
		this.p_id = p_id;
		this.p_photo = p_photo;
		this.a_id = a_id;
		this.p_sign = p_sign;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_photo() {
		return p_photo;
	}

	public void setP_photo(String p_photo) {
		this.p_photo = p_photo;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public int getP_sign() {
		return p_sign;
	}

	public void setP_sign(int p_sign) {
		this.p_sign = p_sign;
	}

}
