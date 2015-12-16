package com.test.a;

import java.util.Timer;
import java.util.TimerTask;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
	/** Called when the activity is first created. */
	//类变量
	private FlowerView mFlowerView; 
	// 屏幕的宽度
	public static int screenWidth;
	// 屏幕的高度
	public static int screenHeight; 
	
	//安卓定时器进行周期性的控制
	Timer myTimer = null;//计时器
	TimerTask mTask = null;//
	/*
	 我是通过Timer与TimerTask相结合实现的定时器功能。具体实现过程如下：
         第一步，得到Timer的实例化对象
     Timer timer= new Timer() ;
          第二步，实例化TimerTask对象
     TimerTask timerTask = new TimerTask(){
     publicvoid run(){
     //Doing something
     }
     }
	 */
	private static final int SNOW_BLOCK = 1;
	private Button buttonxuanze;
	private Button buttonshijuanti;
	private Button buttonjishiti;
	private Button buttonziliao;
	private Button buttonguanyu;
	//刷新
	// handler主要接受子线程发送的数据, 并用此数据配合主线程更新UI
	//子线程应该是子类吧
	private Handler mHandler = new Handler() {
	public void dispatchMessage(Message msg) {
			mFlowerView.inva();
		};
	};
    
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		buttonxuanze=(Button)findViewById(R.id.button1);//选择题
		buttonxuanze.setOnClickListener(this);
		buttonshijuanti=(Button)findViewById(R.id.button2);//真题
		buttonshijuanti.setOnClickListener(this);
		buttonjishiti=(Button)findViewById(R.id.button3);//讲解
		buttonjishiti.setOnClickListener(this);
		buttonziliao=(Button)findViewById(R.id.button4);//资料
		buttonziliao.setOnClickListener(this);
		buttonguanyu=(Button)findViewById(R.id.button5);//关于
		buttonguanyu.setOnClickListener(this);
		
		
		
		//main是连接mainactivity与main的桥梁
		mFlowerView = (FlowerView) findViewById(R.id.flowerview);
		screenWidth = getWindow().getWindowManager().getDefaultDisplay()
				.getWidth();
		screenHeight = getWindow().getWindowManager().getDefaultDisplay()
				.getHeight();
		//Andorid.util 包下的DisplayMetrics 类
		//提供了一种关于显示的通用信息,如显示大小,分辨率和字体
		DisplayMetrics dis = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dis);
		float de = dis.density;
		//设置屏幕宽与高。
		mFlowerView.setWH(screenWidth, screenHeight, de);
		mFlowerView.loadFlower();
		mFlowerView.addRect();

		myTimer = new Timer();
		mTask = new TimerTask() {
			@Override
			public void run() {
				Message msg = new Message();
				msg.what = SNOW_BLOCK;
				mHandler.sendMessage(msg);
			}
		};
		myTimer.schedule(mTask, 3000, 10);
	}
	
	
	@Override
	public void onClick(View v){
		switch(v.getId()){
		case R.id.button1:
			Intent intent=new Intent();
			intent.setClass(this,MainActivity_xuanze.class);
			startActivity(intent);
			break;
		case R.id.button2:
			Intent intent1=new Intent();
			intent1.setClass(this,MainActivity_zhentijiemian.class);
			startActivity(intent1);
			break;
		case R.id.button3:
			Intent intent3=new Intent();
			intent3.setClass(this,MainActivity_jishiti.class);
			startActivity(intent3);
			break; 
        case R.id.button4:
        	Intent intent2=new Intent();
			intent2.setClass(this,MainActivity_jiangjiejiemian.class);
			startActivity(intent2);
			break;
        case R.id.button5:
        	Intent intent4=new Intent();
			intent4.setClass(this,WebBrowser.class);
			startActivity(intent4);
	        break;
		}
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mFlowerView.recly();
	}
}