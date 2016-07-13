package com.HiWeek.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;

/**
 * 
 * @ClassName: ReadStringFormClient
 * @Description: 对来自客户端的Post数据进行获取
 * @author: XU
 * @date: 2015年10月16日 上午10:33:26
 */
public class ClientUtils {
    private static ClientUtils rClient = null;

    private ClientUtils() {

    }

    private static class GetClass {
	static ClientUtils rClient = new ClientUtils();
    }

    public static ClientUtils getInstence() {
	if (rClient == null) {
	    rClient = GetClass.rClient;
	}

	return rClient;
    }

    public String read(InputStream inputStream) {
	BufferedReader reader = new BufferedReader(new InputStreamReader(
		inputStream));
	StringBuilder sbBuilder = new StringBuilder();
	String bufferString;
	try {
	    while ((bufferString = reader.readLine()) != null) {
		sbBuilder.append(URLDecoder.decode(bufferString, "UTF-8"));
	    }
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return sbBuilder.toString();
    }
}
