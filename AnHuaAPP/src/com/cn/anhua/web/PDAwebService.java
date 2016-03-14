package com.cn.anhua.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import com.cn.anhua.entity.CheckInfo;
import com.cn.anhua.entity.InupDetailInfo;
import com.cn.anhua.entity.OutupDetailInfo;
import com.cn.anhua.entity.ZBInfo;
import com.cn.anhua.util.MyLog;
/**
 * 实现网络数据接口
 * @author mac
 *
 */
public class PDAwebService implements IPDAwebService {
	
	//webservice URL 服务器地址
	private final static String SERVICE_URL = "http://123.56.138.171:140";
	
	//命名空间http://tempuri.org/，视具体情况而定
	private final static String SERVICE_SPACE = "http://tempuri.org/" ;
	
	//往数据库中写入盘点记录
	private final static String MEHTOD_CHECKINFO = "CheckInfo";
	
	//获取出库订单编号
	private final static String MEHTOD_OUTORDER_ID = "OutOrderID";
	
	//往数据库中添加一条出库记录
	private final static String MEHTOD_OUTUP_DETAIL_INFO = "OutUpDetailInfo";
	
	//获取应入库的订单编号
	private final static String MEHTOD_INORDER_ID = "InOrderID";
	
	//往数据库中添加一条入库记录
	private final static String MEHTOD_INUP_DETAIL_INFO = "InUpDetailInfo";
	
	//往数据库中添加一条栈板管理记录
	private final static String MEHTOD_ZB_INFO = "ZBInfo";
	
	// 固定8个线程来执行任务
	private ExecutorService executorService = Executors.newFixedThreadPool(8); 
	
	/**
	 * 发送WEB请求,返回结果
	 * @param method  方法名称
	 * @param mapProperty  添加参数
	 * @return
	 * @throws XmlPullParserException 
	 * @throws IOException 
	 */
	private String sendRequest(String method, Map<String, String> mapProperty) throws IOException, XmlPullParserException{
		//第一：实例化SoapObject 对象，指定webService的命名空间
		SoapObject request=new SoapObject(SERVICE_SPACE, method);
		//第二步：假设方法有参数的话,设置调用方法参数
//		request.addProperty("参数名称","参数值");
        if(mapProperty != null){
        	//遍历参数
        	Set<Entry<String, String>> set = mapProperty.entrySet();
        	Iterator<Entry<String, String>> it = set.iterator(); 
        	for(;it.hasNext();){  
        	    Entry<String, String> entry = it.next();  
        	    //添加参数
        	    request.addProperty(entry.getKey(), entry.getValue()) ;
        	    MyLog.e(method + "para","property = " + entry.getKey() + "; value = " + entry.getValue());  
        	} 
        }
		//第三步：设置SOAP请求信息(参数部分为SOAP协议版本号，与你要调用的webService中版本号一致)
		//获得序列化的Envelope
        SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.bodyOut=request;
        //第四步：注册Envelope,
//        MarshalBase64 mar = new MarshalBase64();
//        ﻿mar.register(envelope) ;

		//第五步：构建传输对象，并指明WSDL文档URL,设置网络连接超时
      //Android传输对象
//        AndroidHttpTransport transport=new AndroidHttpTransport(SERVICE_URL );
        HttpTransportSE transport = new HttpTransportSE(SERVICE_URL, 10000) ;
        transport.debug=true;
        //第六步：调用WebService(其中参数为1：命名空间+方法名称，2：Envelope对象):
			transport.call(SERVICE_SPACE+method, envelope);
			//第七步：解析返回数据
			if(envelope.getResponse()!=null){
                MyLog.e("pda web service", method + "response ---->" + envelope.getResponse().toString())  ;
                return envelope.getResponse().toString() ;
            }
		
		return null ;
	}

	/**
	 * 解析返回数据
	 * @param resp
	 * @return
	 */
	private String[] resolveResp(String resp){
		String[] array = resp.split("\\|") ;
		return array ;
	}
	
	/**
	 * 获取出库订单编号
	 */
	@Override
	public void getOutOrderID(final WebCallBack webCall) {
		 executorService.submit(new Runnable() {
			
			@Override
			public void run() {
				String resp = null;
				//调用获取出库订单编号的接口，参数无
				try {
					resp = sendRequest(MEHTOD_OUTORDER_ID, null) ;
				} catch (IOException e) {
					//回调
					webCall.call(resolveResp(resp), WebError.ERR_IO);
					e.printStackTrace();
				} catch (XmlPullParserException e) {
					//回调
					webCall.call(resolveResp(resp), WebError.ERR_XML);
					e.printStackTrace();
				}
				if(resp.length() > 1){
					//回调
					webCall.call(resolveResp(resp), WebError.ERR_OK);
//					return resolveResp(resp) ;
				}else if(resp.length() == 1 && "1".equals(resp)){
					webCall.call(null, WebError.ERR_OK);
				}else{
					webCall.call(null, WebError.ERR_UNKNOW);
				}
				
			}
		});
		
		

	}

	@Override
	public void setOutDetailInfo(OutupDetailInfo OutInfo , WebCallBack webCall) {
		// TODO Auto-generated method stub
//		return false;
	}

	@Override
	public void getInOrderID(WebCallBack webCall) {
		// TODO Auto-generated method stub
//		return null;
	}

	@Override
	public void setInDetailInfo(InupDetailInfo info , WebCallBack webCall) {
		// TODO Auto-generated method stub
//		return false;
	}

	@Override
	public void setCheckInfo(CheckInfo checkInfo, WebCallBack webCall) {
		// TODO Auto-generated method stub
//		return false;
	}

	@Override
	public void setZBInfo(ZBInfo zbInfo , WebCallBack webCall) {
		// TODO Auto-generated method stub
//		return false;
	}

}
