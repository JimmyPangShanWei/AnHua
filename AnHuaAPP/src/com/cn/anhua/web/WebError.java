package com.cn.anhua.web;

import java.util.HashMap;
import java.util.Map;

/**
 * 网络异常处理
 * @author mac
 *
 */
public class WebError {

	
	public final static Map<String, String> ERR_MAP  = new HashMap<String, String>();
	
	
	//正确返回
	public final static String ERR_OK = "ok";
	//超时错误
	public final static String ERR_TIMEOUT = "err_timeout";
	//IO错误
	public final static String ERR_IO = "err_io";
	//xml解析错误
	public final static String ERR_XML = "err_xml";
	
	//未知错误
	public final static String ERR_UNKNOW= "err_unknow";
	
	static{
		ERR_MAP.put(ERR_TIMEOUT, "网络超时") ;
		ERR_MAP.put(ERR_IO, "IO异常") ;
		ERR_MAP.put(ERR_XML, "xml解析异常") ;
		ERR_MAP.put(ERR_UNKNOW, "未知错误") ;
	}
//	//超时错误
//	public final static String ERR_TIMEOUT = "timeout";
//	//超时错误
//	public final static String ERR_TIMEOUT = "timeout";

}
