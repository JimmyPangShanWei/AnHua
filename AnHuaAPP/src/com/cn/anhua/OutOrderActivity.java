package com.cn.anhua;

import com.cn.anhua.base.MBaseActivity;

import android.os.Bundle;
/**
 * 出库
 * 首先订单选择
 * 第二步，点击“开始扫描”，栈板信息中显示扫描到的数据（多条）
 * @author mac
 *
 */
public class OutOrderActivity extends MBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_out_order) ;
	}

	@Override
	public void initView() {
		super.setTitle(getString(R.string.out_order)) ;
		//设置返回键可见
		super.setBackKeyVisible(true) ;
	}
}
