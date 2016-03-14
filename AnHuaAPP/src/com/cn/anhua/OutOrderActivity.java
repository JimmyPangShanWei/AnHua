package com.cn.anhua;

import com.cn.anhua.base.MBaseActivity;

import android.os.Bundle;
/**
 * 出库
 * 首先订单选择
 * 第二步，点击“开始扫描”，栈板信息中显示扫描到的数据（多条）
 * 再次点击“停止扫描”停止扫描，在右边那一列对层数进行编辑，将对应每个栈板
 * 所含的周转箱层数编辑好之后，可以选择“选择上传”（对其中的一条或几条），
 * 也可以选择“批量上传”（将全部数据上传），将栈板EPC和层数传入数据库中
 * （表名：cc_orderdetail_info，“订单编号”存入表中的det_OrdID字段；
 *   “EPC”存入表中的det_PalEPC字段，“层数”存入表中的det_Opallayer字段）。
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
