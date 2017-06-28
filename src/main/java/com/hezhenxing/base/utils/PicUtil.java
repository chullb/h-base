package com.hezhenxing.base.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 水货
 * Date: 2016/10/29
 * Time: 11:22
 * To change this template use File | Settings | File Templates.
 */
public class PicUtil {

	//比较两张图片是否一样
	public static void pictureComparison() {
		try {
			File files = new File("D:\\upload\\client\\2016001007");
			Map<String, String> picMap = new HashMap<>();
			File[] toFile = files.listFiles();

			for (File file : toFile) {
				byte[] bytes = FileUtils.readFileToByteArray(file);
				String picMd5 = getTuPianMD5(bytes);

				if (picMap.containsKey(picMd5)) {
					String fileName = picMap.get(picMd5);
					System.out.println(fileName);
					System.out.println(file.getName());
				} else {
					picMap.put(picMd5, file.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f'};

	private static String getTuPianMD5(byte[] tuPianBytes) {
		if (tuPianBytes == null) {
			return "";
		}
		byte[] strTemp = tuPianBytes;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(strTemp);
			byte[] md = digest.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (NoSuchAlgorithmException ignore) {
			return null;
		}
	}

	public static void main(String[] args) {
		pictureComparison();
	}
}
