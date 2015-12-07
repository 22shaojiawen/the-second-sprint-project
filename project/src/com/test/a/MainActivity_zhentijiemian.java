package com.test.a;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity_zhentijiemian extends Activity implements OnClickListener{
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;
	private Button btn6;
	private Button btn7;
	private Button btn8;
	private Button btn9;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhentijimian);	
		btn1=(Button)findViewById(R.id.button1);
		btn1.setOnClickListener(this);
		btn2=(Button)findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		btn3=(Button)findViewById(R.id.button3);
		btn3.setOnClickListener(this);
		btn4=(Button)findViewById(R.id.button4);
		btn4.setOnClickListener(this);
		btn5=(Button)findViewById(R.id.button5);
		btn5.setOnClickListener(this);
		btn6=(Button)findViewById(R.id.button6);
		btn6.setOnClickListener(this);
		btn7=(Button)findViewById(R.id.button7);
		btn7.setOnClickListener(this);
		btn8=(Button)findViewById(R.id.button8);
		btn8.setOnClickListener(this);
		btn9=(Button)findViewById(R.id.button9);
		btn9.setOnClickListener(this);
	}
	
	@Override
    public void onClick(View v){
	switch(v.getId()){
	case R.id.button1:
		Intent intent=new Intent();
		intent.setClass(this,MainActivity_chuji1.class);
		startActivity(intent);
		break;
	case R.id.button2:
		Intent intent1=new Intent();
		intent1.setClass(this,MainActivity_chuji2.class);
		startActivity(intent1);
		break;
	case R.id.button3:
		Intent intent2=new Intent();
		intent2.setClass(this,MainActivity_chuji3.class);
		startActivity(intent2);
		break;
	case R.id.button4:
		Intent intent3=new Intent();
		intent3.setClass(this,MainActivity_zhongji1.class);
		startActivity(intent3);
		break;
	case R.id.button5:
		Intent intent4=new Intent();
		intent4.setClass(this,MainActivity_zhongji2.class);
		startActivity(intent4);
		break;
	case R.id.button6:
		Intent intent5=new Intent();
		intent5.setClass(this,MainActivity_zhongji3.class);
		startActivity(intent5);
		break;
	case R.id.button7:
		Intent intent6=new Intent();
		intent6.setClass(this,MainActivity_gaoji1.class);
		startActivity(intent6);
		break;
	case R.id.button8:
		Intent intent7=new Intent();
		intent7.setClass(this,MainActivity_gaoji2.class);
		startActivity(intent7);
		break;
	case R.id.button9:
		Intent intent8=new Intent();
		intent8.setClass(this,MainActivity_gaoji3.class);
		startActivity(intent8);
		break;
	}
}
}
