package com.test.a;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_gaoji3 extends Activity {

	private EditText  editText1;
	private EditText  editText2;
	private EditText  editText3;
	private EditText  editText4;
	private EditText  editText5;
	
	private TextView  TextView05;
	private String  str1;
	private String  str2;
	private String  str3;
	private String  str4;
	private String  str5;
	
	private int     FenShu=0;
	private Button button;
	private Button daan;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gaoji3);
		
		editText1 = (EditText)findViewById(R.id.editText1);
		editText2 = (EditText)findViewById(R.id.editText2);
		editText3 = (EditText)findViewById(R.id.editText3);
		editText4 = (EditText)findViewById(R.id.editText4);
		editText5 = (EditText)findViewById(R.id.editText5);
		
		TextView05= (TextView)findViewById(R.id.TextView05);
		button= (Button)findViewById(R.id.button1);
		daan= (Button)findViewById(R.id.button2);
		daan.setEnabled(false);
		
		
		button.setOnClickListener(new View.OnClickListener() {  
            public void onClick(View v) {  
             	str1=editText1.getText().toString();
        		str2=editText2.getText().toString();
        		str3=editText3.getText().toString();
        		str4=editText4.getText().toString();
        		str5=editText5.getText().toString();
        		
            
            	if(str1.equals("9"))
            	{
            		FenShu=FenShu+20;
            	}
            	if(str2.equals("1"))
            	{
            		FenShu=FenShu+20;
            	}
            	if(str3.equals("80"))
            	{
            		FenShu=FenShu+20;
            	}
            	if(str4.equals("15"))
            	{
            		FenShu=FenShu+20;
            	}
            	if(str5.equals("3"))
            	{
            		FenShu=FenShu+20;
            	}
            	
            	TextView05.setText("����:"+FenShu+"");
            	FenShu=0;
            	daan.setEnabled(true);
            }  
        });
		daan.setOnClickListener(new View.OnClickListener() {  
            public void onClick(View v) {  
             	
            	button.setEnabled(false);
            	setContentView(R.layout.nianchuyi9);
            }  
        });  
	}
}
