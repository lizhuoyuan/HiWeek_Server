package com.HiWeek.net.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.HiWeek.Bean.Cinema;
import com.HiWeek.net.bean.CinemaData;
import com.HiWeek.net.bean.CinemaResult;
import com.HiWeek.net.bean.CinemaRoot;
import com.google.gson.Gson;

public class CinemaUtil {
	static final String HTTPURL = "http://v.juhe.cn/movie/cinemas.search";
	static final String KEY = "dca1d94fecb6675766c3a756328a7ff6";
	Gson gson;

	/**
	 * 
	 * @param id
	 *            城市ID 测试期间为21 苏州的ID
	 * @return
	 */
	public CinemaUtil() {
		gson = new Gson();
	}

	public String getCinema(int id, int page) {
		// 根据ID查询城市内的电影院
		// 在此固定为文件中获取
		InputStream is = CinemaUtil.class
				.getResourceAsStream("/CinemaInfo.txt");
		// String httpArg = "cityid=" + id + "&keyword=&page=" + page
		// + "&pagesize=20&dtype=&key=" + KEY;
		// InputStream is = getStream(HTTPURL, httpArg);
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String s;
		StringBuilder sb = new StringBuilder();
		try {
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public ArrayList<Cinema> getCinemaData(int id) {
		ArrayList<Cinema> cinemas = new ArrayList<>();
		String jsonStr = getCinema(id, 1);
		// 对Json解析
		CinemaRoot root = gson.fromJson(jsonStr, CinemaRoot.class);
		CinemaResult result = root.getResult();
		// result.getTotalpage();
		List<CinemaData> datas = result.getData();
		for (CinemaData cinemaData : datas) {
			// int c_id, String c_name, String c_address, String c_tel,
			// float c_lat, float c_lon, String c_city, String c_traffic
			Cinema cinema = new Cinema(cinemaData.getId(),
					cinemaData.getCinemaName(), cinemaData.getAddress(),
					cinemaData.getTelephone(), cinemaData.getLatitude(),
					cinemaData.getLongitude(), cinemaData.getCityName(),
					cinemaData.getTrafficRoutes());
			// System.out.println(cinema.getC_name());
			cinemas.add(cinema);
		}
		return cinemas;
	}

	public InputStream getStream(String httpUrl, String httpArg) {

		httpUrl = httpUrl + "?" + httpArg;
		InputStream is = null;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			// // 填入apikey到HTTP header
			// connection.setRequestProperty("apikey",
			// "1ffe82e756eac7cc93312290c74302b8");
			connection.connect();
			is = connection.getInputStream();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return is;
	}
	// public static void main(String[] args) {
	// new CinemaUtil().getCinemaData(0);
	// }
}
