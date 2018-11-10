/**
 * @author mingfei.z 2018年11月4日 下午10:30:13
 */
package com.shuhang.file.constants;

public class Constants {

	/**
	 * 有效状态
	 * 
	 * @author mingfei.z
	 */
	public static class STATUS {
		/** 1 - 有效 */
		public static int YES = 1;
		/** 1 - 有效 */
		public static byte YES_BYTE = 1;
		/** 0 - 无效 */
		public static int NO = 0;
		/** 0 - 无效 */
		public static byte NO_BYTE = 0;
	}
	
	/**
	 * 字符编码
	 * 
	 * @author mingfei.z 2018年11月10日 下午4:48:40
	 */
	public static class CHARSET {
		public static final String UTF_8 = "UTF-8";
	}
	
	/**
	 * 分隔符
	 * 
	 * @author mingfei.z 2018年11月10日 下午5:47:09
	 */
	public static class SEPARATOR {
		public static final String UNDERLINE = "_";
		public static final String COMMA_CN = "，";
		public static final String COMMA_EN = ",";
	}
	
}
