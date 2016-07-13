package com.HiWeek.net.bean;

public class CinemaRoot {

	private String reason;

	private CinemaResult result;

	private int error_code;

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return this.reason;
	}

	public void setResult(CinemaResult result) {
		this.result = result;
	}

	public CinemaResult getResult() {
		return this.result;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public int getError_code() {
		return this.error_code;
	}

}
