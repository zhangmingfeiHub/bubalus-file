/**
 * @author mingfei.z 2018年11月4日 下午10:53:06
 */
package com.shuhang.file.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils extends org.springframework.util.StringUtils {

	private static final String RANDOM_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String RANDOM_NUMBER = "0123456789";
	
	/**
	 * 生成指定位数 由数字组成的随机字符串
	 * 
	 * @param length
	 * @return
	 * @author mingfei.z 2018年11月4日 下午11:22:57
	 */
	public static String getRandomNum(int length){
		String random = generateRandomStr(RANDOM_NUMBER, length);
		return random;
	}

	/**
	 * 生成指定位数 由大小写字母组成的随机字符串
	 * 
	 * @param length
	 * @return
	 * @author mingfei.z 2018年11月4日 下午11:22:17
	 */
	public static String getRandomString(int length){
		String random = generateRandomStr(RANDOM_CHARS, length);
		return random;
	}

	/**
	 * 生成指定位数 由数字、大小写字母组成的随机字符串
	 * 
	 * @param length
	 * @return
	 * @author mingfei.z 2018年11月4日 下午11:22:17
	 */
	public static String getRandomNumAndString(int length){
		String random = generateRandomStr("", length);
		return random;
	}
	
	/**
	 * 生成指定位数的随机字符串
	 * 
	 * @param key 指定种子字符串，如果未指定，则随机字符由大小写字母组成
	 * @param length 指定长度
	 * @return
	 * @author mingfei.z 2018年11月4日 下午11:18:50
	 */
	public static String getRandomString(String key, int length){
	    if(StringUtils.isEmpty(key)){
	        key = RANDOM_CHARS;
	    }
	    
        return generateRandomStr(key, length);
	}
	
	/**
	 * 生成指定位数的随机字符串
	 * 
	 * @param key 指定种子字符串，如果未指定，则随机字符由数字、大小写字母组成
	 * @param length 指定长度
	 * @return
	 * @author mingfei.z 2018年11月4日 下午11:18:22
	 */
	public static String generateRandomStr(String key, int length) {
		
		if (isEmpty(key))
			key = RANDOM_NUMBER + RANDOM_CHARS;
		
		return RandomStringUtils.random(length, key);
	}
	
//	public static void main(String[] args) {
//		String string = getRandomNumAndString(26);
//		System.out.println(string);
//		String random = RandomStringUtils.random(32, RANDOM_NUMBER + RANDOM_CHARS);
//		System.out.println(random);
//		String num = getRandomNum(22);
//		System.out.println(num);
//		String string2 = getRandomString(20);
//		System.out.println(string2);
//		String string3 = getRandomString("DFG", 20);
//		System.out.println(string3);
//	}
	
}
