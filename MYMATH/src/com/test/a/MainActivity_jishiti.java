package com.test.a;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity_jishiti extends Activity implements OnClickListener{

	private Button button_feixuan;
	private Button button_xuanze;
	private Button button_tongji;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jishiti); 
		button_feixuan=(Button)findViewById(R.id.button1);
		button_feixuan.setOnClickListener(this);
		button_xuanze=(Button)findViewById(R.id.button2);
		button_xuanze.setOnClickListener(this);
		button_tongji=(Button)findViewById(R.id.button3);
		button_tongji.setOnClickListener(this);
	}

	
	    @Override
	    public void onClick(View v){
		switch(v.getId()){
		case R.id.button1:
			Intent intent=new Intent();
			intent.setClass(this,MainActivity_feixuan1.class);
			startActivity(intent);
			break;
		case R.id.button2:
			Intent intent1=new Intent();
			intent1.setClass(this,jishi_xuanze.class);
			startActivity(intent1);
			break;
		case R.id.button3:
			Intent intent2=new Intent();
			intent2.setClass(this,draw.class);
			startActivity(intent2);
			break;
		}
	}
}
