package com.test.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class DrawImg extends View {
private int time5_score=0;
private int time4_score=0;
private int time3_score=0;
private int time2_score=0;
private int time1_score=0;
private SharedPreferences sp;
private SharedPreferences.Editor editor;


	public DrawImg(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public DrawImg(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DrawImg(Context context) {
		super(context);
	}
	
	// 绘制文本
	private void drawTxtView(Canvas canvas,String drawTxt) {
		Paint txtPaint = new Paint();
		txtPaint.setColor(Color.BLUE);
		// 设置文本位置
		txtPaint.setTextAlign(Align.LEFT);
		
		// 设置文本大小
		txtPaint.setTextSize(28);
		// 设置画笔的锯齿效果 true表示无锯齿 false 反之
		txtPaint.setAntiAlias(true);
		txtPaint.setTypeface(Typeface.MONOSPACE);
		// 当然也可以设置为"实心"(Paint.Style.FILL), "空心"(Paint.Style.STROKE)
//		txtPaint.setStyle(Paint.Style.STROKE);
		// 设置“空心”的外框的宽度
//		txtPaint.setStrokeWidth(5);
		// x默认是drawTxt这个字符的左边在屏幕的位置，如果设置了setTextAlign(Paint.Align.CENTER);那就是字符的中心，y是指定这个字符baseline在屏幕上的位置。 
		canvas.drawText(drawTxt, 0, 50, txtPaint);
	}
	
	
	//绘制圆点
	private void drawCircleView(Canvas canvas,float cx,float xy,boolean isSx,int color) {
		Paint circlePaint = new Paint();//画笔
		circlePaint.setColor(color);
		if (isSx) {
			circlePaint.setStyle(Paint.Style.FILL);//实心
		}else {
			circlePaint.setStyle(Paint.Style.STROKE);//设置画笔的类型
		}
//		circlePaint.setStrokeCap(Cap.ROUND);   /**设置画笔变为圆滑状**/ 
		/**
		 * 画点 ： 参数介绍
		 * 1.起始端点的X坐标。
		 * 2.起始端点的Y坐标。
		 * 3.点直径。
		 * 5.绘制直线所使用的画笔。
		 */
		canvas.drawCircle(cx, xy, 5, circlePaint);
	}
	
	// 绘制线段
	private void drawSlash(Canvas canvas,float startX,float startY,float stopX,float stopY) {
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		// 设置线宽
		paint.setStrokeWidth(2f);
		/**
		 * 画线 ： 参数介绍
		 * 1.起始端点的X坐标。
		 * 2.起始端点的Y坐标。
		 * 3.终止端点的X坐标。
		 * 4.终止端点的Y坐标。
		 * 5.绘制直线所使用的画笔。
		 */
		canvas.drawLine(startX, startY, stopX, stopY, paint);
	}
	
	private void drawText(Canvas canvas,String str,float x,float y) {
		Paint paint = new Paint();
		paint.setColor(Color.DKGRAY);
		paint.setTextSize(18);
		/**
		 * 画文本 ： 参数介绍
		 * 1.文本X坐标假指长度
		 * 2.文本Y坐标假指高度
		 * 3.绘制直线所使用的画笔。
		 */
		canvas.drawText(str, x, y, paint);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {//可以置80-480为可行区域。10分就是40像素。
		super.onDraw(canvas);
		if(draw.biaozhi>=5)
		{
			drawTxtView(canvas, "近五次分数成绩统计折线图");
			drawCircleView(canvas,43,480-draw.shuju5*4, true,Color.CYAN);
			drawCircleView(canvas,143,480-draw.shuju4*4, true,Color.BLUE);
			drawCircleView(canvas,243,480-draw.shuju3*4, true,Color.GREEN);
			drawCircleView(canvas,343,480-draw.shuju2*4, true,Color.RED);
			drawCircleView(canvas,443,480-draw.shuju1*4, true,Color.YELLOW);
			/*drawSlash(canvas,107,215,230,260);
			drawSlash(canvas,238,260,420,170);
			drawSlash(canvas,427,170,610,210);*/
			
			drawSlash(canvas,43,480-draw.shuju5*4,143,480-draw.shuju4*4);
			drawSlash(canvas,143,480-draw.shuju4*4,243,480-draw.shuju3*4);
			drawSlash(canvas,243,480-draw.shuju3*4,343,480-draw.shuju2*4);
			drawSlash(canvas,343,480-draw.shuju2*4,443,480-draw.shuju1*4);
			
			
			drawSlash(canvas,0,480,480,480);
			drawText(canvas, ""+draw.shuju5, 33, (480-draw.shuju5*4)-10);//点x-10,点y-10
			drawText(canvas, ""+draw.shuju4, 133,  (480-draw.shuju4*4)-10);
			drawText(canvas, ""+draw.shuju3, 233,  (480-draw.shuju3*4)-10);
			drawText(canvas, ""+draw.shuju2, 333,  (480-draw.shuju2*4)-10);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);
			drawText(canvas, "前第五次", 6, 530);
			drawText(canvas, "前第四次", 106, 530);
			drawText(canvas, "前第三次", 206, 530);
			drawText(canvas, "前第二次", 306, 530);
			drawText(canvas, "前第一次", 406, 530);
		}
		if(draw.biaozhi==4)
		{
			drawTxtView(canvas, "近五次分数成绩统计折线图");
			
			drawCircleView(canvas,143,480-draw.shuju4*4, true,Color.BLUE);
			drawCircleView(canvas,243,480-draw.shuju3*4, true,Color.GREEN);
			drawCircleView(canvas,343,480-draw.shuju2*4, true,Color.RED);
			drawCircleView(canvas,443,480-draw.shuju1*4, true,Color.YELLOW);
			/*drawSlash(canvas,107,215,230,260);
			drawSlash(canvas,238,260,420,170);
			drawSlash(canvas,427,170,610,210);*/
			
			drawSlash(canvas,143,480-draw.shuju4*4,243,480-draw.shuju3*4);
			drawSlash(canvas,243,480-draw.shuju3*4,343,480-draw.shuju2*4);
			drawSlash(canvas,343,480-draw.shuju2*4,443,480-draw.shuju1*4);
			
			
			drawSlash(canvas,0,480,480,480);
			//点x-10,点y-10
			drawText(canvas, ""+draw.shuju4, 133,  (480-draw.shuju4*4)-10);
			drawText(canvas, ""+draw.shuju3, 233,  (480-draw.shuju3*4)-10);
			drawText(canvas, ""+draw.shuju2, 333,  (480-draw.shuju2*4)-10);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);
			
			drawText(canvas, "前第四次", 106, 530);
			drawText(canvas, "前第三次", 206, 530);
			drawText(canvas, "前第二次", 306, 530);
			drawText(canvas, "前第一次", 406, 530);
		}
		if(draw.biaozhi==3)
		{
			drawTxtView(canvas, "近五次分数成绩统计折线图");
			
			drawCircleView(canvas,243,480-draw.shuju3*4, true,Color.GREEN);
			drawCircleView(canvas,343,480-draw.shuju2*4, true,Color.RED);
			drawCircleView(canvas,443,480-draw.shuju1*4, true,Color.YELLOW);
			/*drawSlash(canvas,107,215,230,260);
			drawSlash(canvas,238,260,420,170);
			drawSlash(canvas,427,170,610,210);*/
			
			drawSlash(canvas,243,480-draw.shuju3*4,343,480-draw.shuju2*4);
			drawSlash(canvas,343,480-draw.shuju2*4,443,480-draw.shuju1*4);
			drawSlash(canvas,0,480,480,480);
			
			drawText(canvas, ""+draw.shuju3, 233,  (480-draw.shuju3*4)-10);
			drawText(canvas, ""+draw.shuju2, 333,  (480-draw.shuju2*4)-10);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);
			
			drawText(canvas, "前第三次", 206, 530);
			drawText(canvas, "前第二次", 306, 530);
			drawText(canvas, "前第一次", 406, 530);
		}
		if(draw.biaozhi==2)
		{
			drawTxtView(canvas, "近五次分数成绩统计折线图");
			
			drawCircleView(canvas,343,480-draw.shuju2*4, true,Color.RED);
			drawCircleView(canvas,443,480-draw.shuju1*4, true,Color.YELLOW);
			
			drawSlash(canvas,343,480-draw.shuju2*4,443,480-draw.shuju1*4);
			
			
			
			drawSlash(canvas,0,480,480,480);
			
			drawText(canvas, ""+draw.shuju2, 333,  (480-draw.shuju2*4)-10);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);
			
			drawText(canvas, "前第二次", 306, 530);
			drawText(canvas, "前第一次", 406, 530);
		}
		if(draw.biaozhi==1)
		{
			drawTxtView(canvas, "近五次分数成绩统计折线图");
			
			drawCircleView(canvas,443,480-draw.shuju1*4, true,Color.YELLOW);
			drawSlash(canvas,0,480,480,480);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);	
			drawText(canvas, "前第一次", 406, 530);
		}
		if(draw.biaozhi<=0)
		{}
	
		
		
	}
}
