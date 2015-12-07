package com.test.a;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity_xuanze extends Activity implements OnClickListener{

	private Button buttonchuji;
	private Button buttongaoji;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xuanze); 
		buttonchuji=(Button)findViewById(R.id.button1);
		buttonchuji.setOnClickListener(this);
		buttongaoji=(Button)findViewById(R.id.button2);
		buttongaoji.setOnClickListener(this);
	}

	
	    @Override
	    public void onClick(View v){
		switch(v.getId()){
		case R.id.button1:
			Intent intent=new Intent();
			intent.setClass(this,MainActivity_chuji.class);
			startActivity(intent);
			break;
		case R.id.button2:
			Intent intent1=new Intent();
			intent1.setClass(this,MainActivity_gaoji.class);
			startActivity(intent1);
			break;
		}
	}
}
