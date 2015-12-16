package com.test.a;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class jishiti_tiankongdaan extends Activity {
	private TextView  TextView1;
	private TextView  TextView2;
	private TextView  TextView3;
	private TextView  TextView4;
	private TextView  TextView5;
	private TextView  TextView6;
	private TextView  TextView7;
	private TextView  TextView8;
	private TextView  TextView9;
	private TextView  TextView10;
	private TextView  TextView11;
	private String[] timu_daan=new String[20];//题目与答案
	private Bundle bundle;
	private Intent intent;
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.jishi_daan);  
	        TextView1= (TextView)findViewById(R.id.textView1);
	        TextView2= (TextView)findViewById(R.id.textView2);
	        TextView3= (TextView)findViewById(R.id.textView3);
	        TextView4= (TextView)findViewById(R.id.textView4);
	        TextView5= (TextView)findViewById(R.id.textView5);
	        TextView6= (TextView)findViewById(R.id.textView6);
	        TextView7= (TextView)findViewById(R.id.textView7);
	        TextView8= (TextView)findViewById(R.id.textView8);
	        TextView9= (TextView)findViewById(R.id.textView9);
	        TextView10=(TextView)findViewById(R.id.textView10);
	        TextView11=(TextView)findViewById(R.id.textView11);
	        intent = this.getIntent();
	        bundle = intent.getExtras();
	        timu_daan = bundle.getStringArray("timu_daan");
	        TextView2.setText(timu_daan[0]+timu_daan[10]);
	        TextView3.setText(timu_daan[1]+timu_daan[11]);
	        TextView4.setText(timu_daan[2]+timu_daan[12]);
	        TextView5.setText(timu_daan[3]+timu_daan[13]);
	        TextView6.setText(timu_daan[4]+timu_daan[14]);
	        TextView7.setText(timu_daan[5]+timu_daan[15]);
	        TextView8.setText(timu_daan[6]+timu_daan[16]);
	        TextView9.setText(timu_daan[7]+timu_daan[17]);
	        TextView10.setText(timu_daan[8]+timu_daan[18]);
	        TextView11.setText(timu_daan[9]+timu_daan[19]);
            
	    }  
}
