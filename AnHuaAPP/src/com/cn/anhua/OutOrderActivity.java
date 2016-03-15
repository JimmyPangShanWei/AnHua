package com.cn.anhua;

import com.cn.anhua.base.MBaseActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
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

	//订单选择
	private Spinner spinnerOrder ;
	//栈板信息
	private ListView listZB ;
	//开始扫描
	private Button btnStart ; 
	//选择上传
	private Button btnSelUpload ; 
	//批量上传
	private Button btnMulUpload ; 
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
		spinnerOrder = (Spinner) findViewById(R.id.spinner_out_order_select_order) ;
		listZB = (ListView) findViewById(R.id.listView_out_order_zb_info) ;
		btnStart = (Button) findViewById(R.id.button_out_order_start_scan) ;
		btnSelUpload = (Button) findViewById(R.id.button_out_order_sel_upload) ;
		btnMulUpload = (Button) findViewById(R.id.button_out_order_mul_upload) ;
	}
}
