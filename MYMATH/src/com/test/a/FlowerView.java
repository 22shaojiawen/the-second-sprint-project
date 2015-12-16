package com.test.a;

import java.util.Random;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

//��ͼ
public class FlowerView extends View {

	Bitmap mFlowers = null;//ͼƬ
	MyFlower flowers [] = new MyFlower[25];//�����
	private Integer[] offsetX ;//x������
	//ֱ�Ӵ���ֵ integer�Ƕ���,��һ������ָ���������  
	//integer�Ǹ�����������
	private Integer[] offsetY ;//y������
	Random r = new Random();//�����
	Matrix m = new Matrix();//ͼƬ�����ݾ���
	Paint p = new Paint();//����
	
	int mW = 480;//��
	int mH = 800;//��
	float de = 0f;//��f��ʾ������
	
	
	//����x��y�����鼯��
	public void setWH(int pW, int pH, float de){
		this.mW = pW;
		this.mH = pH;
		this.de = de;
		System.out.println("de ---->" + de);
		offsetX = new Integer[]{(int)(2*de), (int)(-2*de), (int)(-1*de), 0, (int)(1*de), (int)(2*de), (int)(1*de)};
		offsetY = new Integer[]{(int)(3*de), (int)(5*de), (int)(5*de), (int)(3*de), (int)(4*de)};
	}
	
	
	
	//��׿view����������
	
	public FlowerView(Context context) {
		super(context);
		//����һ���ǵ��ø�����вεĹ��췽��
	}
    
	
	public FlowerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
    
	
	public FlowerView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}
	
	
	//��ѩ��
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		for (int i = 0; i < flowers.length; i++) {
			MyFlower rect = flowers[i];
			int t = rect.t;
			t--;
			if (t <= 0) {
				rect.y += rect.g;
				canvas.save();
				//save() : ��������Canvas��״̬,save()����֮��Ĵ��룬
				//���Ե���Canvas��ƽ�ơ���������ת���ü��Ȳ�����
				
				m.reset();
				m.setScale(rect.s, rect.s);
				canvas.setMatrix(m);
				p.setAlpha(rect.a);
				canvas.drawBitmap(mFlowers, rect.x, rect.y, p);
				canvas.restore();
				//restore()�������ָ�Canvas֮ǰ�����״̬(��������Ǳ����������״̬),
				//��ֹsave()��������֮���Canvasִ�еĲ����������Ժ����Ļ��ƻ����Ӱ��,
				//ͨ���÷������Ա���������Ӱ��
			}
			rect.t = t;
			if (rect.y >= mH) {
				rect.init();
			}
			if (rect.x >= mW || rect.x < - 20) {
				rect.init();
			}
			flowers[i] = rect;
		}
	}
	
	
	//��ȡͼƬ��Դ
	public void loadFlower(){
		Resources r = this.getContext().getResources();
		mFlowers = ((BitmapDrawable)r.getDrawable(R.drawable.snow)).getBitmap();
	}
	
	//����ͼƬ
	public void recly(){
		if (mFlowers != null && !mFlowers.isRecycled()) {
			mFlowers.recycle();
			//����ͼƬ    Ӧ����ѩ����ʧ����е�Ч����
		}
	}
	
	//ͼƬ����
	public void addRect(){
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = new MyFlower();
		}
	}
	
	//ˢ�½���
	public void inva(){
		invalidate();
		//ʵ��view�ĸ��������鷽��,һ����invalidate,
		//��һ����postInvalidate,����ǰ������UI�߳�������ʹ��,�������ڷ�UI�߳���ʹ�á�
	}
	
	
	//ͼƬ�Ĳ�����r�������
	class MyFlower{
		int x;
		int y;
		float s;
		int a;
		int t;
		int g;
		
		public void init(){
			float aa = r.nextFloat();			
			this.x = r.nextInt(mW - 80) + 80;
			this.y = 0;
			if (aa >= 1) {
				this.s = 1.1f;
			}else if (aa <= 0.2) {
				this.s = 0.4f;
			}else{
				this.s = aa;
			}
			this.a = r.nextInt(155) + 100;
			this.t = r.nextInt(105) + 1;
			this.g = offsetY[r.nextInt(4)];
		}
		
		//���仰˵����super()��this ()�������ڹ��췽���ĵ�һ�С�
		//this(�в���/�޲���) ���ڵ��ñ�����Ӧ�Ĺ��캯�� 
		public MyFlower(){
			super();
			init();
		}		
		
	}
	
}