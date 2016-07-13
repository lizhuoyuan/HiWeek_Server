package com.HiWeek.net.bean;

public class CinemaData {
	private int id;

	private String cityName;

	private String cinemaName;

	private String address;

	private String telephone;

	private float latitude;

	private float longitude;

	private String trafficRoutes;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getCinemaName() {
		return this.cinemaName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLongitude() {
		return this.longitude;
	}

	public void setTrafficRoutes(String trafficRoutes) {
		this.trafficRoutes = trafficRoutes;
	}

	public String getTrafficRoutes() {
		return this.trafficRoutes;
	}

}
