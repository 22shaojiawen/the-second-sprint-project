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

//视图
public class FlowerView extends View {

	Bitmap mFlowers = null;//图片
	MyFlower flowers [] = new MyFlower[25];//类矩阵
	private Integer[] offsetX ;//x轴坐标
	//直接存数值 integer是对象,用一个引用指向这个对象  
	//integer是复杂数据类型
	private Integer[] offsetY ;//y轴坐标
	Random r = new Random();//随机数
	Matrix m = new Matrix();//图片里数据矩阵
	Paint p = new Paint();//画笔
	
	int mW = 480;//宽
	int mH = 800;//高
	float de = 0f;//加f表示浮点数
	
	
	//设置x，y的数组集合
	public void setWH(int pW, int pH, float de){
		this.mW = pW;
		this.mH = pH;
		this.de = de;
		System.out.println("de ---->" + de);
		offsetX = new Integer[]{(int)(2*de), (int)(-2*de), (int)(-1*de), 0, (int)(1*de), (int)(2*de), (int)(1*de)};
		offsetY = new Integer[]{(int)(3*de), (int)(5*de), (int)(5*de), (int)(3*de), (int)(4*de)};
	}
	
	
	
	//安卓view的属性设置
	
	public FlowerView(Context context) {
		super(context);
		//这是一句是调用父类的有参的构造方法
	}
    
	
	public FlowerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
    
	
	public FlowerView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}
	
	
	//画雪花
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
				//save() : 用来保存Canvas的状态,save()方法之后的代码，
				//可以调用Canvas的平移、放缩、旋转、裁剪等操作！
				
				m.reset();
				m.setScale(rect.s, rect.s);
				canvas.setMatrix(m);
				p.setAlpha(rect.a);
				canvas.drawBitmap(mFlowers, rect.x, rect.y, p);
				canvas.restore();
				//restore()：用来恢复Canvas之前保存的状态(可以想成是保存坐标轴的状态),
				//防止save()方法代码之后对Canvas执行的操作，继续对后续的绘制会产生影响,
				//通过该方法可以避免连带的影响
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
	
	
	//获取图片资源
	public void loadFlower(){
		Resources r = this.getContext().getResources();
		mFlowers = ((BitmapDrawable)r.getDrawable(R.drawable.snow)).getBitmap();
	}
	
	//回收图片
	public void recly(){
		if (mFlowers != null && !mFlowers.isRecycled()) {
			mFlowers.recycle();
			//回收图片    应该是雪花消失后才有的效果吧
		}
	}
	
	//图片数组
	public void addRect(){
		for (int i = 0; i < flowers.length; i++) {
			flowers[i] = new MyFlower();
		}
	}
	
	//刷新界面
	public void inva(){
		invalidate();
		//实现view的更新有两组方法,一组是invalidate,
		//另一组是postInvalidate,其中前者是在UI线程自身中使用,而后者在非UI线程中使用。
	}
	
	
	//图片的参数，r是随机数
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
		
		//换句话说就是super()和this ()都必须在构造方法的第一行。
		//this(有参数/无参数) 用于调用本类相应的构造函数 
		public MyFlower(){
			super();
			init();
		}		
		
	}
	
}