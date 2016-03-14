package com.cn.anhua.web;

import java.util.List;

import com.cn.anhua.entity.CheckInfo;
import com.cn.anhua.entity.InupDetailInfo;
import com.cn.anhua.entity.OutupDetailInfo;
import com.cn.anhua.entity.ZBInfo;

/**
 * webservice服务接口
 * @author mac
 *
 */
public interface IPDAwebService {

	/**
	 * 获取出库订单ID
	 * @return
	 */
	void getOutOrderID(WebCallBack webCall) ;
	
	/**
	 * 往数据库中添加一条出库记录
	 * @param info
	 * @return
	 */
	void setOutDetailInfo(OutupDetailInfo OutInfo , WebCallBack webCall) ;
	
	/**
	 * 获取入库订单ID
	 * @return
	 */
	void getInOrderID(WebCallBack webCall) ;
	
	/**
	 * 往数据库中添加一条入库记录
	 * @param info
	 * @return
	 */
	void setInDetailInfo(InupDetailInfo info , WebCallBack webCall) ;
	
	/**
	 * 往数据库中写入盘点记录
	 * @param checkInfo
	 * @return
	 */
	void setCheckInfo(CheckInfo checkInfo , WebCallBack webCall) ;
	
	/**
	 * 往数据库中写入一条栈板记录
	 * @param zbInfo
	 * @return
	 */
	void setZBInfo(ZBInfo zbInfo , WebCallBack webCall) ;
}
