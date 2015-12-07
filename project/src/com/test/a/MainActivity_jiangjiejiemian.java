package com.test.a;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity_jiangjiejiemian extends Activity implements OnClickListener{
	private Button jia;
	private Button jian;
	private Button cheng; 
	private Button chu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sizejiangjie); 	 
		jia=(Button)findViewById(R.id.button1);
		jia.setOnClickListener(this);
		jian=(Button)findViewById(R.id.button2);
		jian.setOnClickListener(this);
		cheng=(Button)findViewById(R.id.button3);
		cheng.setOnClickListener(this);
		chu=(Button)findViewById(R.id.button4);
		chu.setOnClickListener(this);
	}
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case R.id.button1:
			Intent intent=new Intent();
			intent.setClass(this,MainActivity_jiangjie.class);
			startActivity(intent);
			break;
		case R.id.button2:
			Intent intent1=new Intent();
			intent1.setClass(this,MainActivity_jiangjie1.class);
			startActivity(intent1);
			break;
		case R.id.button3:
			Intent intent2=new Intent();
			intent2.setClass(this,MainActivity_jiangjie2.class);
			startActivity(intent2);
			break;
		case R.id.button4:
			Intent intent3=new Intent();
			intent3.setClass(this,MainActivity_jiangjie3.class);
			startActivity(intent3);
			break;
		}
	
	}
	}
	

