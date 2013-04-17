package com.ryantang.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * StreamUtils
 * @author Ryan
 */
public final class StreamUtils {
	
	/**
	 * String convert to InputStream
	 * @param content
	 * @return
	 */
	public static InputStream stringToInputStream(String content){
		if (content == null || content.equals("")) {
			return null;
		}
		return new ByteArrayInputStream(content.getBytes());
	}

	/**
	 * InputStream convert to String
	 * @param inputStream
	 * @return
	 */
	public static String inputStreamToString(InputStream inputStream){
		if (inputStream == null) {
			return null;
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return stringBuilder.toString();
	}
	
	/**
	 * InputStream convert to byte[] 
	 */
	public static byte[] inputStreamToBytes(InputStream inputStream)
			throws Exception {
		if (inputStream == null) {
			return null;
		}
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);
		}
		outputStream.close();
		inputStream.close();
		return outputStream.toByteArray();
	}
}
