package com.cn.anhua.application;

import com.android.hdhe.uhf.reader.UhfReader;

import android.app.Application;

/**
 * 用于存放全局变量
 * @author admin
 *
 */
public class AnhuaApplication extends Application {
	private UhfReader uhf ;
	
	//获取UHF操作句柄
	public UhfReader getUHF(){
		uhf = UhfReader.getInstance() ;
		return uhf ;
	}
	
	//关闭
	public void close(){
		if(uhf != null){
			uhf.close() ;
		}
	}
}
