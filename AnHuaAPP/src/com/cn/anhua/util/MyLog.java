package com.cn.anhua.util;

import android.util.Log;

/**
 * 打印日志信息,便于统一管理
 * @author mac
 *
 */
public class MyLog {

	/**
	 * 打印红色错误信息
	 * @param tag
	 * @param msg
	 */
	public static void e(String tag, String msg){
		Log.e(tag, msg) ;
	}
	
	/**
	 * 打印信息
	 * @param tag
	 * @param msg
	 */
	public static void i(String tag, String msg){
		Log.i(tag, msg) ;
	}
}
