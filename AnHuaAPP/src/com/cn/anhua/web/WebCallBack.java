package com.cn.anhua.web;

/**
 * WEB 请求返回接口
 * @author mac
 *
 */
public interface WebCallBack {
	/**
	 * 回调接口
	 * @param obj  返回数据
	 * @param errState  返回状态信息  
	 */
	void call(Object obj, String errState) ;

}
