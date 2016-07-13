package com.HiWeek.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class SelectUtil {

	public static SelectUtil selectUtil = null;
	private JSONObject jsob;

	public static SelectUtil getInstance() {
		if (selectUtil == null) {
			selectUtil = new SelectUtil();
		}
		return selectUtil;
	}

	public SelectUtil() {
		File file = new File(SelectUtil.class.getResource("areas.json")
				.getPath());
		if (!file.exists()) {
			System.out.println("文件不存在！");
			return;
		}
		FileInputStream fis;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			String string = null;
			StringBuilder sb = new StringBuilder();
			while ((string = br.readLine()) != null) {
				sb.append(string);
			}
			jsob = JSON.parseObject(sb.toString());

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (br != null)
					br.close();
				br = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getProvences() {
		ArrayList<String> provinceList = new ArrayList<>();
		for (Entry<String, Object> entry : jsob.entrySet()) {
			provinceList.add(entry.getKey());
		}

		return JSON.toJSONString(provinceList);
	}

	public String getCity(String proName) {
		ArrayList<String> cityList = new ArrayList<>();
		for (Entry<String, Object> entry : jsob.getJSONObject(proName)
				.entrySet()) {
			cityList.add(entry.getKey());
		}

		return JSON.toJSONString(cityList);
	}

	public String getCountry(String proName, String cityNme) {
		ArrayList<String> countryList = new ArrayList<>();
		JSONArray jsArray = jsob.getJSONObject(proName).getJSONArray(cityNme);
		for (Object object : jsArray) {
			countryList.add(object.toString());
		}
		return JSON.toJSONString(countryList);
	}

}
