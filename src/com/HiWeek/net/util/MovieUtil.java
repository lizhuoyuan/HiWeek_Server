package com.HiWeek.net.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.HiWeek.Bean.Movie;
import com.HiWeek.net.bean.MovieID;
import com.HiWeek.net.bean.MovieInfo;
import com.HiWeek.net.bean.MovieInfoRoot;
import com.HiWeek.net.bean.MovieRoot;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class MovieUtil {
	static final String IDHTTPURL = "http://v.juhe.cn/movie/movies.today";
	static final String QUERY_HTTP_URL = "http://v.juhe.cn/movie/query";
	static final String KEY = "dca1d94fecb6675766c3a756328a7ff6";
	private Gson gson = new Gson();

	private String getIDInfo(int cityID) {
		// is = MovieUtil.class.getResourceAsStream("/MovieID.txt");
		// 获取今日放映电影
		String HttpArgs = "cityid=" + cityID + "&dtype=&key=" + KEY;
		InputStream is = getStream(IDHTTPURL, HttpArgs);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String str;
		try {

			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}

	public ArrayList<MovieID> getMovieID(int cityid)
			throws JsonSyntaxException, UnsupportedEncodingException {
		MovieRoot mRoot = gson.fromJson(getIDInfo(cityid), MovieRoot.class);
		ArrayList<MovieID> ids = mRoot.getResult();
		return ids;
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

	/**
	 * 根据ID集合，依次取到详细信息，并返回处理好的电影信息集合<br>
	 * 测试时是从文件中获取
	 * 
	 * @return
	 */
	public Movie getMovieInfo(int id) {
		// InputStream infois = MovieUtil.class
		// .getResourceAsStream("/MovieInfo.txt");
		String httpArg = "movieid=" + id + "&dtype=&key=" + KEY;
		InputStream is = getStream(QUERY_HTTP_URL, httpArg);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		String s;
		try {
			while ((s = reader.readLine()) != null) {
				sb.append(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String info = sb.toString();
		// System.out.println(info);
		MovieInfoRoot root = gson.fromJson(info, MovieInfoRoot.class);
		MovieInfo mInfo = root.getResult();
		// 将对应值赋值到需要的Bean
		/*
		 * int m_id, String m_name, String m_poster, String m_introduce,double
		 * m_grade, String m_director, String m_district,String m_duration,
		 * String m_date, String m_genres, String m_language, String m_year
		 */
		Movie movie = new Movie(Integer.parseInt(mInfo.getMovieid()),
				mInfo.getTitle(), mInfo.getPoster(), mInfo.getPlot_simple(),
				Double.parseDouble(mInfo.getRating()), mInfo.getDirectors(),
				mInfo.getCountry(), mInfo.getRuntime(), mInfo.getRelease_date()
						+ "", mInfo.getGenres(), mInfo.getLanguage(),
				mInfo.getYear() + "");
		return movie;
	}

	public ArrayList<Movie> getMovies(int cityID) {
		ArrayList<Movie> movies = new ArrayList<>();

		try {
			ArrayList<MovieID> ids = getMovieID(cityID);
			for (MovieID movieID : ids) {
				System.out.println(movieID.getMovieId());
				movies.add(getMovieInfo(movieID.getMovieId()));
			}
		} catch (JsonSyntaxException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return movies;
	}
	// public static void main(String[] args) {
	// System.out.println(new MovieUtil().getMovieInfo().get(0).getM_name());
	//
	// }
}
