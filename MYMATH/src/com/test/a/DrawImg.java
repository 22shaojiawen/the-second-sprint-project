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
	
	// �����ı�
	private void drawTxtView(Canvas canvas,String drawTxt) {
		Paint txtPaint = new Paint();
		txtPaint.setColor(Color.BLUE);
		// �����ı�λ��
		txtPaint.setTextAlign(Align.LEFT);
		
		// �����ı���С
		txtPaint.setTextSize(28);
		// ���û��ʵľ��Ч�� true��ʾ�޾�� false ��֮
		txtPaint.setAntiAlias(true);
		txtPaint.setTypeface(Typeface.MONOSPACE);
		// ��ȻҲ��������Ϊ"ʵ��"(Paint.Style.FILL), "����"(Paint.Style.STROKE)
//		txtPaint.setStyle(Paint.Style.STROKE);
		// ���á����ġ������Ŀ��
//		txtPaint.setStrokeWidth(5);
		// xĬ����drawTxt����ַ����������Ļ��λ�ã����������setTextAlign(Paint.Align.CENTER);�Ǿ����ַ������ģ�y��ָ������ַ�baseline����Ļ�ϵ�λ�á� 
		canvas.drawText(drawTxt, 0, 50, txtPaint);
	}
	
	
	//����Բ��
	private void drawCircleView(Canvas canvas,float cx,float xy,boolean isSx,int color) {
		Paint circlePaint = new Paint();//����
		circlePaint.setColor(color);
		if (isSx) {
			circlePaint.setStyle(Paint.Style.FILL);//ʵ��
		}else {
			circlePaint.setStyle(Paint.Style.STROKE);//���û��ʵ�����
		}
//		circlePaint.setStrokeCap(Cap.ROUND);   /**���û��ʱ�ΪԲ��״**/ 
		/**
		 * ���� �� ��������
		 * 1.��ʼ�˵��X���ꡣ
		 * 2.��ʼ�˵��Y���ꡣ
		 * 3.��ֱ����
		 * 5.����ֱ����ʹ�õĻ��ʡ�
		 */
		canvas.drawCircle(cx, xy, 5, circlePaint);
	}
	
	// �����߶�
	private void drawSlash(Canvas canvas,float startX,float startY,float stopX,float stopY) {
		Paint paint = new Paint();
		paint.setColor(Color.GRAY);
		// �����߿�
		paint.setStrokeWidth(2f);
		/**
		 * ���� �� ��������
		 * 1.��ʼ�˵��X���ꡣ
		 * 2.��ʼ�˵��Y���ꡣ
		 * 3.��ֹ�˵��X���ꡣ
		 * 4.��ֹ�˵��Y���ꡣ
		 * 5.����ֱ����ʹ�õĻ��ʡ�
		 */
		canvas.drawLine(startX, startY, stopX, stopY, paint);
	}
	
	private void drawText(Canvas canvas,String str,float x,float y) {
		Paint paint = new Paint();
		paint.setColor(Color.DKGRAY);
		paint.setTextSize(18);
		/**
		 * ���ı� �� ��������
		 * 1.�ı�X�����ָ����
		 * 2.�ı�Y�����ָ�߶�
		 * 3.����ֱ����ʹ�õĻ��ʡ�
		 */
		canvas.drawText(str, x, y, paint);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {//������80-480Ϊ��������10�־���40���ء�
		super.onDraw(canvas);
		if(draw.biaozhi>=5)
		{
			drawTxtView(canvas, "����η����ɼ�ͳ������ͼ");
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
			drawText(canvas, ""+draw.shuju5, 33, (480-draw.shuju5*4)-10);//��x-10,��y-10
			drawText(canvas, ""+draw.shuju4, 133,  (480-draw.shuju4*4)-10);
			drawText(canvas, ""+draw.shuju3, 233,  (480-draw.shuju3*4)-10);
			drawText(canvas, ""+draw.shuju2, 333,  (480-draw.shuju2*4)-10);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);
			drawText(canvas, "ǰ�����", 6, 530);
			drawText(canvas, "ǰ���Ĵ�", 106, 530);
			drawText(canvas, "ǰ������", 206, 530);
			drawText(canvas, "ǰ�ڶ���", 306, 530);
			drawText(canvas, "ǰ��һ��", 406, 530);
		}
		if(draw.biaozhi==4)
		{
			drawTxtView(canvas, "����η����ɼ�ͳ������ͼ");
			
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
			//��x-10,��y-10
			drawText(canvas, ""+draw.shuju4, 133,  (480-draw.shuju4*4)-10);
			drawText(canvas, ""+draw.shuju3, 233,  (480-draw.shuju3*4)-10);
			drawText(canvas, ""+draw.shuju2, 333,  (480-draw.shuju2*4)-10);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);
			
			drawText(canvas, "ǰ���Ĵ�", 106, 530);
			drawText(canvas, "ǰ������", 206, 530);
			drawText(canvas, "ǰ�ڶ���", 306, 530);
			drawText(canvas, "ǰ��һ��", 406, 530);
		}
		if(draw.biaozhi==3)
		{
			drawTxtView(canvas, "����η����ɼ�ͳ������ͼ");
			
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
			
			drawText(canvas, "ǰ������", 206, 530);
			drawText(canvas, "ǰ�ڶ���", 306, 530);
			drawText(canvas, "ǰ��һ��", 406, 530);
		}
		if(draw.biaozhi==2)
		{
			drawTxtView(canvas, "����η����ɼ�ͳ������ͼ");
			
			drawCircleView(canvas,343,480-draw.shuju2*4, true,Color.RED);
			drawCircleView(canvas,443,480-draw.shuju1*4, true,Color.YELLOW);
			
			drawSlash(canvas,343,480-draw.shuju2*4,443,480-draw.shuju1*4);
			
			
			
			drawSlash(canvas,0,480,480,480);
			
			drawText(canvas, ""+draw.shuju2, 333,  (480-draw.shuju2*4)-10);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);
			
			drawText(canvas, "ǰ�ڶ���", 306, 530);
			drawText(canvas, "ǰ��һ��", 406, 530);
		}
		if(draw.biaozhi==1)
		{
			drawTxtView(canvas, "����η����ɼ�ͳ������ͼ");
			
			drawCircleView(canvas,443,480-draw.shuju1*4, true,Color.YELLOW);
			drawSlash(canvas,0,480,480,480);
			drawText(canvas, ""+draw.shuju1, 433,  (480-draw.shuju1*4)-10);	
			drawText(canvas, "ǰ��һ��", 406, 530);
		}
		if(draw.biaozhi<=0)
		{}
	
		
		
	}
}
