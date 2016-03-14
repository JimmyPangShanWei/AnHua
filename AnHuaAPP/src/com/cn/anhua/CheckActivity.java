package com.cn.anhua;

import android.os.Bundle;

import com.cn.anhua.base.MBaseActivity;

public class CheckActivity extends MBaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_out_order) ;
	}

	@Override
	public void initView() {
		super.setTitle(getString(R.string.out_order)) ;
		
	}

}
