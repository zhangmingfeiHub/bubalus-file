/**
 * @author mingfei.z 2018年11月5日 上午10:31:36
 */
package com.shuhang.file.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

//	private static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
//	private static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * 获取当前日期的年
	 * 
	 * @return
	 * @author mingfei.z 2018年11月5日 上午10:39:02
	 */
	public static String getYearString() {
		
		Calendar c = Calendar.getInstance();
		return c.get(Calendar.YEAR) + "";
	}

	/**
	 * 获取指定日期的年
	 * 
	 * @param date
	 * @return
	 * @author mingfei.z 2018年11月5日 上午10:39:35
	 */
	public static String getYearString(Date date) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR) + "";
	}

	/**
	 * 获取当前日期的月
	 * 
	 * @return
	 * @author mingfei.z 2018年11月5日 上午10:39:02
	 */
	public static String getMonthString() {
		
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH) + 1;//获取月份
		return month < 10 ? "0" + month : month + "";
	}

	/**
	 * 获取指定日期的月
	 * 
	 * @param date
	 * @return
	 * @author mingfei.z 2018年11月5日 上午10:39:35
	 */
	public static String getMonthString(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH) + 1;//获取月份
		return month < 10 ? "0" + month : month + "";
	}

	/**
	 * 获取当前日期的日
	 * 
	 * @return
	 * @author mingfei.z 2018年11月5日 上午10:39:02
	 */
	public static String getDayString() {
		
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DATE);//获取日
		return day < 10 ? "0" + day : day + "";
	}

	/**
	 * 获取指定日期的日
	 * 
	 * @param date
	 * @return
	 * @author mingfei.z 2018年11月5日 上午10:39:35
	 */
	public static String getDayString(Date date) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = c.get(Calendar.DATE);//获取日
		return day < 10 ? "0" + day : day + "";
	}
	
//	public static void main(String[] args) {
//		String yearString = getYearString();
//		String yearString2 = getYearString(new Date());
//		String monthString = getMonthString();
//		String monthString2 = getMonthString(new Date());
//		String dayString = getDayString();
//		String dayString2 = getDayString(new Date());
//		
//		System.err.println(yearString);
//		System.err.println(yearString2);
//		System.err.println(monthString);
//		System.err.println(monthString2);
//		System.err.println(dayString);
//		System.err.println(dayString2);
//	}
	
}
