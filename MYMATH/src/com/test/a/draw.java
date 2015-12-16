package com.test.a;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;

public class draw extends Activity {
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	public static int shuju1;
	public static int shuju2;
	public static int shuju3;
	public static int shuju4;
	public static int shuju5;
	public static int true1=0;
	public static int true2=0;
	public static int true3=0;
	public static int true4=0;
	public static int true5=0;
	public static int biaozhi=1;//应该标记已有数据
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		sp=getSharedPreferences("MySP", MODE_PRIVATE);
		biaozhi=sp.getInt("a_biaozhi", 1);
		/*editor=sp.edit();
		editor.putInt("num", 1);
		editor.commit();*/
		if(biaozhi>=5)
		{
			shuju1=sp.getInt("a_shuju1", 0);	
			shuju2=sp.getInt("a_shuju2", 0);
			shuju3=sp.getInt("a_shuju3", 0);
			shuju4=sp.getInt("a_shuju4", 0);
			shuju5=sp.getInt("a_shuju5", 0);
		}
		if(biaozhi==4)
		{
			shuju1=sp.getInt("a_shuju1", 0);	
			shuju2=sp.getInt("a_shuju2", 0);
			shuju3=sp.getInt("a_shuju3", 0);
			shuju4=sp.getInt("a_shuju4", 0);
		}
		if(biaozhi==3)
		{
			shuju1=sp.getInt("a_shuju1", 0);	
			shuju2=sp.getInt("a_shuju2", 0);
			shuju3=sp.getInt("a_shuju3", 0);
		}
		if(biaozhi==2)
		{
			shuju1=sp.getInt("a_shuju1", 0);	
			shuju2=sp.getInt("a_shuju2", 0);
		}
		if(biaozhi==1)
		{
			shuju1=sp.getInt("a_shuju1", 0);	
		}
		DrawImg img = new DrawImg(this);
		setContentView(img);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
}
