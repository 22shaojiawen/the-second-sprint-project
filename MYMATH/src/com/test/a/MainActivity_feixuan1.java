package com.test.a;



import android.app.Activity; 
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
//使用线程实现的TextView 时钟需要线程Thread、Handler（发送、处理消息）辅助实现
public class MainActivity_feixuan1 extends Activity implements Runnable{
	
	private TextView myTextView;
	private TextView t1,t2,t3,t4,t5;
	private Button shang_button,xia_button,queding_button,daan_button;
	private Thread mThread;
	private Handler myHandler;
	private boolean shangorxia=false;
	private int fenshu[]=new int[10];//分数记录
	private String jieshoushuju[]=new String[3];//接受数据的字符串
	private String[][] daan=new String[10][2];//答案
	private String[] timu=new String[10];
	private String[] chulidaan=new String[10];//待处理的答案
	private jishitiku_feixuan  jishigongshi=new jishitiku_feixuan(); 
	private EditText edit1,edit2,edit3,edit4,edit5;
	private int diyiordier=1;
	private int zhongfen=0;
	private boolean kuaiguan=true;//显示时间快关
	private boolean kuaiguan2=true;//计分开关
	protected static final int msg_Key = 0x1234;
	private long yy=102;
	
	
	//主要将资料放进去就行了
	private  int a_shuju1;//记录的数据
	private  int a_shuju2;
	private  int a_shuju3;
	private  int a_shuju4;
	private  int a_shuju5;
	private  int a_true1=0;
	private  int a_true2=0;
	private  int a_true3=0;
	private  int a_true4=0;
	private  int a_true5=0;
	private  int a_biaozhi=0;
	private boolean define_final=true;
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	private String[] timu_daan=new String[20];//题目与答案
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feixuan1);
        
        //读入部分
        sp=getSharedPreferences("MySP", MODE_PRIVATE);
		editor=sp.edit();
		a_biaozhi=sp.getInt("a_biaozhi", 0);
		
		
		//首次使用部分
		if(a_biaozhi==0)
		   {
			   editor.putInt("a_biaozhi", 0);
			   editor.commit();
		//     Toast.makeText(MainActivity_feixuan1.this, "第1次使用", Toast.LENGTH_LONG).show();
		   }
		
		
        //模拟时钟的实现不需要额外代码，只需要UI 中添加，其自动显示时间
        myTextView=(TextView)findViewById(R.id.textView6);
        t1=(TextView)findViewById(R.id.textView2);
        t2=(TextView)findViewById(R.id.textView1);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        shang_button=(Button)findViewById(R.id.button1);
        xia_button=(Button)findViewById(R.id.button2);
        queding_button=(Button)findViewById(R.id.button3);
        edit1=(EditText)findViewById(R.id.editText1);
        edit2=(EditText)findViewById(R.id.EditText01);
        edit3=(EditText)findViewById(R.id.editText2);
        edit4=(EditText)findViewById(R.id.editText3);
        edit5=(EditText)findViewById(R.id.editText4);
        daan_button=(Button)findViewById(R.id.button4);
        daan_button.setEnabled(false);
        
        for(int i=0;i<=9;i++)
        {
        	jieshoushuju=jishigongshi.four_number();
        	timu[i]=jieshoushuju[0];
        	daan[i][0]=jieshoushuju[1];
        	daan[i][1]=jieshoushuju[2];
        	chulidaan[i]="";
        	timu_daan[i]=jieshoushuju[0];
        	timu_daan[i+10]=jieshoushuju[1];
        }
        
        t1.setText(timu[0]);
        t2.setText(timu[1]);
        t3.setText(timu[2]);
        t4.setText(timu[3]);
        t5.setText(timu[4]);

        shang_button.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0) 
			{
				    diyiordier=1;
					t1.setText(timu[0]);
			        t2.setText(timu[1]);
			        t3.setText(timu[2]);
			        t4.setText(timu[3]);
			        t5.setText(timu[4]);
			        edit1.setText(chulidaan[0]);
			        edit2.setText(chulidaan[1]);
			        edit3.setText(chulidaan[2]);
			        edit4.setText(chulidaan[3]);
			        edit5.setText(chulidaan[4]);
			        
			}
		});
        xia_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) 
			{
				diyiordier=2;
				t1.setText(timu[5]);
		        t2.setText(timu[6]);
		        t3.setText(timu[7]);
		        t4.setText(timu[8]);
		        t5.setText(timu[9]);
		        edit1.setText(chulidaan[5]);
		        edit2.setText(chulidaan[6]);
		        edit3.setText(chulidaan[7]);
		        edit4.setText(chulidaan[8]);
		        edit5.setText(chulidaan[9]);
			}
		});
        
        
        
        
        daan_button.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) 
			{
				
				Intent intent = new Intent();
			    intent.setClass(MainActivity_feixuan1.this, jishiti_tiankongdaan.class);
			    Bundle bundle=new Bundle();
			    bundle.putStringArray("timu_daan", timu_daan);
			    intent.putExtras(bundle); 
			    startActivity(intent);
				
			}
		});
        
        
        
        
        
        queding_button.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View arg0) 
		{  
			
			   zhongfen=0;
			if(chulidaan[0].equals(daan[0][0])||chulidaan[0].equals(daan[0][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[1].equals(daan[1][0])||chulidaan[1].equals(daan[1][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[2].equals(daan[2][0])||chulidaan[2].equals(daan[2][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[3].equals(daan[3][0])||chulidaan[3].equals(daan[3][1]))
			{
				zhongfen+=10;	
			}
			if(chulidaan[4].equals(daan[4][0])||chulidaan[4].equals(daan[4][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[5].equals(daan[5][0])||chulidaan[5].equals(daan[5][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[6].equals(daan[6][0])||chulidaan[6].equals(daan[6][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[7].equals(daan[7][0])||chulidaan[7].equals(daan[7][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[8].equals(daan[8][0])||chulidaan[8].equals(daan[8][1]))
			{
				zhongfen+=10;
			}
			if(chulidaan[9].equals(daan[9][0])||chulidaan[9].equals(daan[9][1]))
			{
				zhongfen+=10;
			}
			 edit1.setEnabled(false);
			 edit2.setEnabled(false);
			 edit3.setEnabled(false);
			 edit4.setEnabled(false);
			 edit5.setEnabled(false);
			 queding_button.setEnabled(false);
			 kuaiguan=false;
			 daan_button.setEnabled(true);
			
		    }
	});
        /* 通过Handler 来接收进程所传递的信息并更新TextView */
        myHandler=new Handler()
        {
        	@Override
        public void handleMessage(Message msg) {
        		// TODO Auto-generated method stub
        		myTextView.setTextColor(Color.BLUE);
        		if(kuaiguan)
        		{	
					 myTextView.setText("剩余时间:"+yy+"");
        		}
        		else
        		{
        			 myTextView.setText("所得分数:"+zhongfen);
        			 edit1.setEnabled(false);
        			 edit2.setEnabled(false);
        			 edit3.setEnabled(false);
        			 edit4.setEnabled(false);
        			 edit5.setEnabled(false);
        			 queding_button.setEnabled(false);
        			 
        			 if(define_final)
        				{
        					a_biaozhi++;
        					editor.putInt("a_biaozhi", a_biaozhi);
        					editor.commit();
        					if(a_biaozhi==1)
        					{
        						
        						editor.putInt("a_shuju1", zhongfen);
            					editor.commit();
        					}
        					else if(a_biaozhi==2)
        					{
        						a_shuju1=sp.getInt("a_shuju1", 0);
        						a_shuju2=a_shuju1;
        						
        						editor.putInt("a_shuju2", a_shuju2);
        						editor.putInt("a_shuju1", zhongfen);
            					editor.commit();
        					}
        					else if(a_biaozhi==3)
        					{
        						a_shuju1=sp.getInt("a_shuju1", 0);
        						a_shuju2=sp.getInt("a_shuju2", 0);
        						
        						a_shuju3=a_shuju2;
        						a_shuju2=a_shuju1;
        						
        						
        						editor.putInt("a_shuju2", a_shuju2);
        						editor.putInt("a_shuju3", a_shuju3);
        						editor.putInt("a_shuju1", zhongfen);
            					editor.commit();
        					}
        					else if(a_biaozhi==4)
        					{
        						a_shuju1=sp.getInt("a_shuju1", 0);
        						a_shuju2=sp.getInt("a_shuju2", 0);
        						a_shuju3=sp.getInt("a_shuju3", 0);
        						
        						a_shuju4=a_shuju3;
        						a_shuju3=a_shuju2;
        						a_shuju2=a_shuju1;
        						
        						
        						editor.putInt("a_shuju4", a_shuju4);
        						editor.putInt("a_shuju2", a_shuju2);
        						editor.putInt("a_shuju3", a_shuju3);
        						editor.putInt("a_shuju1", zhongfen);
            					editor.commit();
        					}
        					else if(a_biaozhi==5)
        					{
        						a_shuju1=sp.getInt("a_shuju1", 0);
        						a_shuju2=sp.getInt("a_shuju2", 0);
        						a_shuju3=sp.getInt("a_shuju3", 0);
        						a_shuju4=sp.getInt("a_shuju4", 0);
        						
        						a_shuju5=a_shuju4;
        						a_shuju4=a_shuju3;
        						a_shuju3=a_shuju2;
        						a_shuju2=a_shuju1;
        						
        						editor.putInt("a_shuju5", a_shuju5);
        						editor.putInt("a_shuju4", a_shuju4);
        						editor.putInt("a_shuju2", a_shuju2);
        						editor.putInt("a_shuju3", a_shuju3);
        						editor.putInt("a_shuju1", zhongfen);
            					editor.commit();
        					}
        					else if(a_biaozhi>5)
        					{
        						a_shuju1=sp.getInt("a_shuju1", 0);
        						a_shuju2=sp.getInt("a_shuju2", 0);
        						a_shuju3=sp.getInt("a_shuju3", 0);
        						a_shuju4=sp.getInt("a_shuju4", 0);
        						a_shuju5=sp.getInt("a_shuju5", 0);
        						
        						a_shuju5=a_shuju4;
        						a_shuju4=a_shuju3;
        						a_shuju3=a_shuju2;
        						a_shuju2=a_shuju1;
        						
        						editor.putInt("a_shuju5", a_shuju5);
        						editor.putInt("a_shuju4", a_shuju4);
        						editor.putInt("a_shuju2", a_shuju2);
        						editor.putInt("a_shuju3", a_shuju3);
        						editor.putInt("a_shuju1", zhongfen);
            					editor.commit();
        					}
        					define_final=false;
        				}
        		}
				if(diyiordier==1)
				    {
						chulidaan[0]=edit1.getText().toString();
						chulidaan[1]=edit2.getText().toString();
						chulidaan[2]=edit3.getText().toString();
						chulidaan[3]=edit4.getText().toString();
						chulidaan[4]=edit5.getText().toString();
					}
				else{
						chulidaan[5]=edit1.getText().toString();
						chulidaan[6]=edit2.getText().toString();
						chulidaan[7]=edit3.getText().toString();
						chulidaan[8]=edit4.getText().toString();
						chulidaan[9]=edit5.getText().toString();
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
	public void run() {
		// TODO Auto-generated method stub
		try {
			do
			{
				yy--;
				if(yy<=0)
				{
					kuaiguan=false;
					daan_button.setEnabled(true);
				}
				Thread.sleep(1000);
				/* 重要关键程序:取得时间后发出信息给Handler */
				Message msg=new Message();
				msg.what=MainActivity_feixuan1.msg_Key;
				myHandler.sendMessage(msg);/* 重要关键程序:取得时间后发出信息给Handler */
			}
			while(Thread.interrupted()==false);/* 当系统发出中断信息时停止本循环*/
		    } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}


 