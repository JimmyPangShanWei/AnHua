package com.cn.anhua.entity;
/**
 * 入库记录
 * @author mac
 *
 */
public class InupDetailInfo {
		//出库订单
		private String orderId ;
		//EPC号
		private String palEPC ;
		//操作者
		private String inPallayer ;
		
		
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
		public String getInPallayer() {
			return inPallayer;
		}
		public void setInPallayer(String inPallayer) {
			this.inPallayer = inPallayer;
		}
		
}
