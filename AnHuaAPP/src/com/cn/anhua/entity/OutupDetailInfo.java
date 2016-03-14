package com.cn.anhua.entity;
/**
 * 出库记录
 * @author mac
 *
 */
public class OutupDetailInfo {

	//出库订单
	private String orderId ;
	//EPC号
	private String palEPC ;
	//操作者
	private String outPallayer ;
	
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPalEPC() {
		return palEPC;
	}
	public void setPalEPC(String palEPC) {
		this.palEPC = palEPC;
	}
	public String getOutPallayer() {
		return outPallayer;
	}
	public void setOutPallayer(String outPallayer) {
		this.outPallayer = outPallayer;
	}
	
	
}
