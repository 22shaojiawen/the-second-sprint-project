package com.test.a;



import java.text.DecimalFormat;

import android.app.Activity; 
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
//使用线程实现的TextView 时钟需要线程Thread、Handler（发送、处理消息）辅助实现
public class jishi_xuanze extends Activity implements Runnable{
	
	private TextView myTextView;
	private TextView tiMu;//显示题目
	private Thread mThread;
	private Handler myHandler;
	protected static final int msg_Key = 0x1234;
	private long yy=102;
	private ImageButton btn1;
	private ImageButton btn2;
	private ImageButton tijiaobutton;
	private String jieshoushuju[]=new String[3];//接受数据的字符串
	private String gongshi[]=new String[10];//记录公式的字符串
	private int fenshu[]=new int[10];//分数记录
	private int daan_weizhi[]=new int[10];//答案位置
	private String[][] daan=new String[10][2];//答案
	private int daanzuobijiao=4;//判断是否选中正确答案
	private jishi_xuanzhe  jishigongshi=new jishi_xuanzhe(); 
	private RadioButton radio1;
	private RadioButton radio2;
	private RadioButton radio3;
	private int xiabiao=0;
	private int zhongfen=0;
	private int timushengyushu=9;
	private boolean define=true;
	private String[][] qitadaan=new String[10][2];//非正确选项答案
	private int intorfloat=0;
	private DecimalFormat df = new DecimalFormat("#.00");
	
	
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jishi_xuanze);
        //模拟时钟的实现不需要额外代码，只需要UI 中添加，其自动显示时间  
        myTextView=(TextView)findViewById(R.id.TextView01); 
        tiMu=(TextView)findViewById(R.id.cengfa_TextView);//显示题目
        btn1=(ImageButton)findViewById(R.id.imageButton1);
        btn2=(ImageButton)findViewById(R.id.imageButton2);
        tijiaobutton=(ImageButton)findViewById(R.id.imageButton3);
        radio1=(RadioButton)findViewById(R.id.cengfa_radiobutton1);
        radio2=(RadioButton)findViewById(R.id.cengfa_radiobutton2);
        radio3=(RadioButton)findViewById(R.id.cengfa_radiobutton3);
        
        
        for(int i=0;i<=9;i++)	
		{
        	jieshoushuju=jishigongshi.four_number();
        	intorfloat=jishigongshi.defineFloat();
        	gongshi[i]=jieshoushuju[0];
        	daan[i][0]=jieshoushuju[1];
        	daan[i][1]=jieshoushuju[2];
        	fenshu[i]=0;
        	daan_weizhi[i]=(int)(Math.random()*3);
        	if(intorfloat==0)
        	{
        	qitadaan[i][0]=""+(int)(Math.random()*20+1);
        	qitadaan[i][1]=""+(int)(Math.random()*20+1);
        	}
        	if(intorfloat==1)
        	{
        	qitadaan[i][0]=""+df.format((Math.random()*20+1));
            qitadaan[i][1]=""+df.format((Math.random()*20+1));
        	}
		}
        
        tiMu.setText(gongshi[xiabiao]);//初次显示
        switch(daan_weizhi[xiabiao])
        {
        case 0:radio1.setText(daan[xiabiao][0]);radio2.setText(qitadaan[xiabiao][0]);radio3.setText(qitadaan[xiabiao][1]);daanzuobijiao=0;break;
        case 1:radio1.setText(qitadaan[xiabiao][0]);radio2.setText(daan[xiabiao][0]);radio3.setText(qitadaan[xiabiao][1]);daanzuobijiao=1;break;
        case 2:radio1.setText(qitadaan[xiabiao][0]);radio2.setText(qitadaan[xiabiao][1]);radio3.setText(daan[xiabiao][0]);daanzuobijiao=2;break;
        }
        
        btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) 
			{
				if(radio1.isChecked()&&daan_weizhi[xiabiao]==0)
				{
					Toast.makeText(jishi_xuanze.this, "已选", Toast.LENGTH_SHORT).show();
					fenshu[xiabiao]=1;
				}
				else if(radio2.isChecked()&&daan_weizhi[xiabiao]==1)
				{
					Toast.makeText(jishi_xuanze.this, "已选", Toast.LENGTH_SHORT).show();
					fenshu[xiabiao]=1;
				}
				else if(radio3.isChecked()&&daan_weizhi[xiabiao]==2)
				{
					Toast.makeText(jishi_xuanze.this, "已选", Toast.LENGTH_SHORT).show();
					fenshu[xiabiao]=1;
				}
				else
				{
					Toast.makeText(jishi_xuanze.this, "已选", Toast.LENGTH_SHORT).show();
					fenshu[xiabiao]=0;
				}
				    zhongfen=0;
				for(int h=0;h<=9;h++)
				{
			    if(fenshu[h]==1)
			    {
			    	zhongfen+=10;
			    }
				}
			}
		});
        
        btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				xiabiao++;
				timushengyushu--;
				tiMu.setText(gongshi[xiabiao]);
				switch(daan_weizhi[xiabiao])
		        {
		        case 0:radio1.setText(daan[xiabiao][0]);radio2.setText(qitadaan[xiabiao][0]);radio3.setText(qitadaan[xiabiao][1]);daanzuobijiao=0;break;
		        case 1:radio1.setText(qitadaan[xiabiao][0]);radio2.setText(daan[xiabiao][0]);radio3.setText(qitadaan[xiabiao][1]);daanzuobijiao=1;break;
		        case 2:radio1.setText(qitadaan[xiabiao][0]);radio2.setText(qitadaan[xiabiao][1]);radio3.setText(daan[xiabiao][0]);daanzuobijiao=2;break;
		        }
				if(timushengyushu<=0)
				{
					btn1.setEnabled(false);
					btn2.setEnabled(false);
				}
			}
		});
        tijiaobutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{	
			define=false;		
			}
		});
        /* 通过Handler 来接收进程所传递的信息并更新TextView */
        myHandler=new Handler()
        {
        	@Override
                public void handleMessage(Message msg) {//静态内容
        		// TODO Auto-generated method stub
        		 
        		if(define)
        		{
        		if(yy>=0)
        		{
					myTextView.setText("剩余时间:"+yy+"");
					myTextView.setTextColor(Color.GREEN);
        		}
        		if(yy<0)
					{
					myTextView.setText("时间到!分数为:"+zhongfen);
					btn1.setEnabled(false);
					btn2.setEnabled(false);
					}
        		} 
        		else
        		{
        			myTextView.setText("分数为:"+zhongfen);
        			btn1.setEnabled(false);
					btn2.setEnabled(false);
        		}
        		    super.handleMessage(msg);
        	}
        };
        /* 通过进程来持续取得系统时间*/
        mThread=new Thread(this);
        mThread.start();  
        }
     
    
    
    /* 实现一个Runable接口，实例化一个进程对象， 用来持续取得系统时间*/
	@Override
	public void run() {//要变化的内容,动态内容
		// TODO Auto-generated method stub
		try {
			do
			{
				yy--;
				Thread.sleep(1000);
				/* 重要关键程序:取得时间后发出信息给Handler */
				Message msg=new Message();
				msg.what=jishi_xuanze.msg_Key;
				myHandler.sendMessage(msg);/* 重要关键程序:取得时间后发出信息给Handler */
			}
			while(Thread.interrupted()==false);/* 当系统发出中断信息时停止本循环*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}


 