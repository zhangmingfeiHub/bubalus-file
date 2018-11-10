/**
 * @author mingfei.z 2018年11月10日 下午5:35:31
 */
package com.shuhang.file.utils;

import java.util.concurrent.TimeUnit;

public class CommonUtils {

	public static long getSeconds(int timeout, TimeUnit unit) {
		if (timeout <= 0 || null == unit)
			return 0;
		
		long second = 0;
		switch (unit) {
			case DAYS:
				second = timeout * 24 * 60 * 60;
				break;
			case HOURS:
				second = timeout * 60 * 60;
				break;
			case MINUTES:
				second = timeout * 60;
				break;
			case SECONDS:
				second = timeout;
				break;
			default:
				break;
		}
		
		return second;
	}
	
}
