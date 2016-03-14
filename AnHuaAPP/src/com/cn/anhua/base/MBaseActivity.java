package com.cn.anhua.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.cn.anhua.R;
/**
 * 父类activity，将activity中一些公用的方法写在这里，避免重复
 * @author mac
 *
 */
public abstract class MBaseActivity extends Activity {
	
	 //标题
	private TextView tvTitle ; 
	//返回键
	private ImageView imgBack ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		tvTitle = (TextView) findViewById(R.id.textView_title) ;
		imgBack = (ImageView) findViewById(R.id.imageView_back) ;
		initView() ;
	}
	
	//设置返回按键是否可见
	public void setBackKeyVisible(boolean visible){
		if(visible){
			imgBack.setVisibility(View.VISIBLE) ;
		}else{
			imgBack.setVisibility(View.GONE) ;
		}
		
		imgBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish() ;
				
			}
		}); 
	}
	
	
	
	/**
	 * 初始化UI
	 */
	public abstract void initView() ;
	/**
	 * 设置标题
	 * @param mText
	 */
	public void setTitle(String mText){
		tvTitle.setText(mText) ;
	}

}
