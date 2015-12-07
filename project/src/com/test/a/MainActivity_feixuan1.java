package com.test.a;



import android.app.Activity; 
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
//ʹ���߳�ʵ�ֵ�TextView ʱ����Ҫ�߳�Thread��Handler�����͡�������Ϣ������ʵ��
public class MainActivity_feixuan1 extends Activity implements Runnable{
	
	private TextView myTextView;
	private TextView t1,t2,t3,t4,t5;
	private Button shang_button,xia_button,queding_button;
	private Thread mThread;
	private Handler myHandler;
	private boolean shangorxia=false;
	private int fenshu[]=new int[10];//������¼
	private String jieshoushuju[]=new String[3];//�������ݵ��ַ���
	private String[][] daan=new String[10][2];//��
	private String[] timu=new String[10];
	private String[] chulidaan=new String[10];//������Ĵ�
	private jishitiku_feixuan  jishigongshi=new jishitiku_feixuan(); 
	private EditText edit1,edit2,edit3,edit4,edit5;
	private int diyiordier=1;
	private int zhongfen=0;
	private boolean kuaiguan=true;//��ʾʱ����
	private boolean kuaiguan2=true;//�Ʒֿ���
	protected static final int msg_Key = 0x1234;
	private long yy=115;
	
	
	//��Ҫ�����ϷŽ�ȥ������
	private  int a_shuju1;//��¼������
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
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feixuan1);
        
        //���벿��
        sp=getSharedPreferences("MySP", MODE_PRIVATE);
		editor=sp.edit();
		a_biaozhi=sp.getInt("a_biaozhi", 0);
		
		
		//�״�ʹ�ò���
		if(a_biaozhi==0)
		   {
			   editor.putInt("a_biaozhi", 0);
			   editor.commit();
		//     Toast.makeText(MainActivity_feixuan1.this, "��1��ʹ��", Toast.LENGTH_LONG).show();
		   }
		
		
        //ģ��ʱ�ӵ�ʵ�ֲ���Ҫ������룬ֻ��ҪUI ����ӣ����Զ���ʾʱ��
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
        
        for(int i=0;i<=9;i++)
        {
        	jieshoushuju=jishigongshi.four_number();
        	timu[i]=jieshoushuju[0];
        	daan[i][0]=jieshoushuju[1];
        	daan[i][1]=jieshoushuju[2];
        	chulidaan[i]="";
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
			
			
		    }
	});
        /* ͨ��Handler �����ս��������ݵ���Ϣ������TextView */
        myHandler=new Handler()
        {
        	@Override
        public void handleMessage(Message msg) {
        		// TODO Auto-generated method stub
        		myTextView.setTextColor(Color.BLUE);
        		if(kuaiguan)
        		{	
					 myTextView.setText("ʣ��ʱ��:"+yy+"");
        		}
        		else
        		{
        			 myTextView.setText("���÷���:"+zhongfen);
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
        /* ͨ������������ȡ��ϵͳʱ��*/
        mThread=new Thread(this);
        mThread.start();
    }
    /* ʵ��һ��Runable�ӿڣ�ʵ����һ�����̶��� ��������ȡ��ϵͳʱ��*/
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
					
					
				}
				Thread.sleep(1000);
				/* ��Ҫ�ؼ�����:ȡ��ʱ��󷢳���Ϣ��Handler */
				Message msg=new Message();
				msg.what=MainActivity_feixuan1.msg_Key;
				myHandler.sendMessage(msg);/* ��Ҫ�ؼ�����:ȡ��ʱ��󷢳���Ϣ��Handler */
			}
			while(Thread.interrupted()==false);/* ��ϵͳ�����ж���Ϣʱֹͣ��ѭ��*/
		    } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}


 