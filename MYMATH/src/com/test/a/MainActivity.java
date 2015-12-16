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
	//�����
	private FlowerView mFlowerView; 
	// ��Ļ�Ŀ��
	public static int screenWidth;
	// ��Ļ�ĸ߶�
	public static int screenHeight; 
	
	//��׿��ʱ�����������ԵĿ���
	Timer myTimer = null;//��ʱ��
	TimerTask mTask = null;//
	/*
	 ����ͨ��Timer��TimerTask����ʵ�ֵĶ�ʱ�����ܡ�����ʵ�ֹ������£�
         ��һ�����õ�Timer��ʵ��������
     Timer timer= new Timer() ;
          �ڶ�����ʵ����TimerTask����
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
	//ˢ��
	// handler��Ҫ�������̷߳��͵�����, ���ô�����������̸߳���UI
	//���߳�Ӧ���������
	private Handler mHandler = new Handler() {
	public void dispatchMessage(Message msg) {
			mFlowerView.inva();
		};
	};
    
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		buttonxuanze=(Button)findViewById(R.id.button1);//ѡ����
		buttonxuanze.setOnClickListener(this);
		buttonshijuanti=(Button)findViewById(R.id.button2);//����
		buttonshijuanti.setOnClickListener(this);
		buttonjishiti=(Button)findViewById(R.id.button3);//����
		buttonjishiti.setOnClickListener(this);
		buttonziliao=(Button)findViewById(R.id.button4);//����
		buttonziliao.setOnClickListener(this);
		buttonguanyu=(Button)findViewById(R.id.button5);//����
		buttonguanyu.setOnClickListener(this);
		
		
		
		//main������mainactivity��main������
		mFlowerView = (FlowerView) findViewById(R.id.flowerview);
		screenWidth = getWindow().getWindowManager().getDefaultDisplay()
				.getWidth();
		screenHeight = getWindow().getWindowManager().getDefaultDisplay()
				.getHeight();
		//Andorid.util ���µ�DisplayMetrics ��
		//�ṩ��һ�ֹ�����ʾ��ͨ����Ϣ,����ʾ��С,�ֱ��ʺ�����
		DisplayMetrics dis = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dis);
		float de = dis.density;
		//������Ļ����ߡ�
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