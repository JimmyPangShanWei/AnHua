package com.cn.anhua;

import com.cn.anhua.base.MBaseActivity;
import com.cn.anhua.util.MyLog;
import com.cn.anhua.web.PDAwebService;
import com.cn.anhua.web.WebCallBack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 主界面，有出库、入库、盘点、栈板管理、设置五个功能。
 * @author mac
 *
 */
public class MainActivity extends MBaseActivity implements OnClickListener{
	
	private TextView tvTitle ;  //标题
	private Button btnOutOrder ;//出库
	private Button btnInOrder ;//入库
	private Button btnCheck ;//盘点
	private Button btnZBmanager ;//栈板管理
	private ImageView imgSettings ;//设置
	
	private String TAG = "MainActivity" ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_main);
		PDAwebService pda = new PDAwebService() ;
		pda.getOutOrderID(new WebCallBack() {
			
			@Override
			public void call(Object obj, String errState) {
				String err = errState ;
				MyLog.e(TAG, "err -- " + err) ;
				if(obj != null){
					String[] aa = (String[]) obj ;
					MyLog.e(TAG, "result -- " + aa[0]) ;
				}
				
			}
		});
		
	}
	
	@Override
	public void initView(){
		//设置标题名称
		super.setTitle(getString(R.string.app_name)) ;
//		tvTitle = (TextView) findViewById(R.id.textView_title) ;
//		tvTitle.setText(R.string.app_name) ;
		//入库
		btnOutOrder = (Button) findViewById(R.id.button_main_out_order) ;
		btnOutOrder.setOnClickListener(this) ;
		//出库
		btnInOrder = (Button) findViewById(R.id.button_main_in_order) ;
		btnInOrder.setOnClickListener(this) ;
		//盘点
		btnCheck = (Button) findViewById(R.id.button_main_check) ;
		btnCheck.setOnClickListener(this) ;
		//栈板管理
		btnZBmanager = (Button) findViewById(R.id.button_main_zb_manager) ;
		btnZBmanager.setOnClickListener(this) ;
		//设置
		imgSettings = (ImageView) findViewById(R.id.imageView_main_settings) ;
		imgSettings.setOnClickListener(this) ;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_main_out_order://入库
			Intent toOutOrder = new Intent(MainActivity.this, OutOrderActivity.class);
			startActivity(toOutOrder) ;
			break;
		case R.id.button_main_in_order://出库
			Intent toInOrder = new Intent(MainActivity.this, InOrderActivity.class);
			startActivity(toInOrder) ;
			break;
		case R.id.button_main_check://盘点
			Intent toCheck = new Intent(MainActivity.this, CheckActivity.class);
			startActivity(toCheck) ;
			break;
		case R.id.button_main_zb_manager://栈板管理
			Intent toZBmanager = new Intent(MainActivity.this, ZBManagerActivity.class);
			startActivity(toZBmanager) ;
			break;
		case R.id.imageView_main_settings://设置
			
			break;
		default:
			break;
		}
		
	}
}
