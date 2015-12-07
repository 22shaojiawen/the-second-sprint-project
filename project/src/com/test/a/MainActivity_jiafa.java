package com.test.a;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import java.math.*;
public class MainActivity_jiafa extends Activity {
private RadioGroup rg_gender;
private Button btn_select;
private Button xiayiti;
private TextView mytextview;
private int shu1;
private int shu2;
private int shu3;
private int shu4;
private int shu5;
private int shu6;
private RadioButton radio1;
private RadioButton radio2;
private RadioButton radio3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chujijia);
		btn_select=(Button)findViewById(R.id.show);
		xiayiti=(Button)findViewById(R.id.show1);
		rg_gender=(RadioGroup)findViewById(R.id.RG);
		mytextview=(TextView)findViewById(R.id.myTextView);
		radio1=(RadioButton)findViewById(R.id.radiobutton1);
		radio2=(RadioButton)findViewById(R.id.radiobutton2);
		radio3=(RadioButton)findViewById(R.id.radiobutton3);
		
		
		shu1=(int)(Math.random()*10+1);
		shu2=(int)(Math.random()*10+1);
		mytextview.setText(shu1+"+"+shu2+"=");
		shu3=shu1+shu2;
		shu4=(int)(Math.random()*3+1);
		shu5=(int)(Math.random()*20+1);
		shu6=(int)(Math.random()*20+1);
		
		
		
		
		switch(shu4){
		case 1:radio1.setText(""+shu3+"");
		if(shu5==shu3)
		{
			shu5=shu5+(int)(Math.random()*3+1);
			radio2.setText(""+shu5+"");
		}
		else
		{
			radio2.setText(""+shu5+"");
		}
		if(shu6==shu3)
		{
			shu6=shu6+(int)(Math.random()*3+1);
			radio3.setText(""+shu6+"");
		}
		else
		{
			radio3.setText(""+shu6+"");
		}
		break;
		case 2:radio2.setText(""+shu3+"");
		if(shu5==shu3)
		{
			shu5=shu5+(int)(Math.random()*3+1);
			radio1.setText(""+shu5+"");
		}
		else
		{
			radio1.setText(""+shu5+"");
		}
		if(shu6==shu3)
		{
			shu6=shu6+(int)(Math.random()*3+1);
			radio3.setText(""+shu6+"");
		}
		else
		{
			radio3.setText(""+shu6+"");
		}
		break;
		case 3:radio3.setText(""+shu3+"");
		if(shu5==shu3)
		{
			shu5=shu5+(int)(Math.random()*3+1);
			radio1.setText(""+shu5+"");
		}
		else
		{
			radio1.setText(""+shu5+"");
		}
		if(shu6==shu3)
		{
			shu6=shu6+(int)(Math.random()*3+1);
			radio2.setText(""+shu6+"");
		}
		else
		{
			radio2.setText(""+shu6+"");
		}
		break;	
		}
		
				
		
	    
		
		
		    btn_select.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				if(radio1.isChecked())
				{
					if(shu4==1)
					{
					Toast.makeText(MainActivity_jiafa.this, "正确", 
					Toast.LENGTH_SHORT).show();
					
					}
					else
					{
					Toast.makeText(MainActivity_jiafa.this, "错误", 
					Toast.LENGTH_SHORT).show(); 
					
					}
					
				}
				else if(radio2.isChecked())
				{
					if(shu4==2)
					{
					Toast.makeText(MainActivity_jiafa.this, "正确", 
					Toast.LENGTH_SHORT).show();
					
					}
					else
					{
					Toast.makeText(MainActivity_jiafa.this, "错误", 
					Toast.LENGTH_SHORT).show();   
					
					}
					
				}
				else if(radio3.isChecked())
				{
					if(shu4==3)
					{
					Toast.makeText(MainActivity_jiafa.this, "正确", 
					Toast.LENGTH_SHORT).show();
					
					}
					else
					{
					Toast.makeText(MainActivity_jiafa.this, "错误", 
					Toast.LENGTH_SHORT).show();
					
					}
				}
			
		}
	});
		
            xiayiti.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				shu1=(int)(Math.random()*10+1);
				shu2=(int)(Math.random()*10+1);
				mytextview.setText(shu1+"+"+shu2+"=");
				shu3=shu1+shu2;
				shu4=(int)(Math.random()*3+1);
				shu5=(int)(Math.random()*20+1);
				shu6=(int)(Math.random()*20+1);
				
				switch(shu4){
				case 1:radio1.setText(""+shu3+"");
				if(shu5==shu3)
				{
					shu5=shu5+(int)(Math.random()*3+1);
					radio2.setText(""+shu5+"");
				}
				else
				{
					radio2.setText(""+shu5+"");
				}
				if(shu6==shu3)
				{
					shu6=shu6+(int)(Math.random()*3+1);
					radio3.setText(""+shu6+"");
				}
				else
				{
					radio3.setText(""+shu6+"");
				}
				break;
				case 2:radio2.setText(""+shu3+"");
				if(shu5==shu3)
				{
					shu5=shu5+(int)(Math.random()*3+1);
					radio1.setText(""+shu5+"");
				}
				else
				{
					radio1.setText(""+shu5+"");
				}
				if(shu6==shu3)
				{
					shu6=shu6+(int)(Math.random()*3+1);
					radio3.setText(""+shu6+"");
				}
				else
				{
					radio3.setText(""+shu6+"");
				}
				break;
				case 3:radio3.setText(""+shu3+"");
				if(shu5==shu3)
				{
					shu5=shu5+(int)(Math.random()*3+1);
					radio1.setText(""+shu5+"");
				}
				else
				{
					radio1.setText(""+shu5+"");
				}
				if(shu6==shu3)
				{
					shu6=shu6+(int)(Math.random()*3+1);
					radio2.setText(""+shu6+"");
				}
				else
				{
					radio2.setText(""+shu6+"");
				}
				break;	
				}
				
			    }
	});	
	}
}
	
	
	
	
	
	
	


