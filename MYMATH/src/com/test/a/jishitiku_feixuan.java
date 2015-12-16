
package com.test.a;

import java.text.DecimalFormat;

public class jishitiku_feixuan {
private int intorfloat=0;
private DecimalFormat df = new DecimalFormat("#0.00");
	jishitiku_feixuan(){
			
	}
	
	public String[] four_number()
	{
		int shu=(int)(Math.random()*24+1);
		int shu1=(int)(Math.random()*10);
		int shu2=(int)(Math.random()*10);
		int shu3=(int)(Math.random()*10);
		int shu4=(int)(Math.random()*10);
		int shu5=(int)(Math.random()*10);
		int shu9=(int)(Math.random()*10);
		int shu21=(int)(Math.random()*10);
		int shu22=(int)(Math.random()*10);
		int shu23=(int)(Math.random()*10);
		int shu24=(int)(Math.random()*10);
		int shu25=(int)(Math.random()*10);
		int shu6;
		int shu7=(int)(Math.random()*201)-100,shu8=(int)(Math.random()*201)-100;
		String daan;
		String daan1;
		float shu12=(int)(Math.random()*10+1);
		float shu13=(int)(Math.random()*10+1);
		float shu14=(int)(Math.random()*10+1);
		float shu15=(int)(Math.random()*10+1);
		float shu16=(int)(Math.random()*10+1);
		float shu17=(int)(Math.random()*10+1);
		float shu18=(int)(Math.random()*10+1);
		float shu19=(int)(Math.random()*10+1);
		float shu20=(int)(Math.random()*10+1);
		
		String gongsi_daan_daan1[]=new String[3];
	switch(shu)
	{
	case 1:shu6=shu1+shu2+shu4+shu5;System.out.println(shu1+"+"+shu2+"+"+shu4+"+"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"+"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 2:shu6=shu1-shu2-shu4-shu5;
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"-"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break; 
	case 3:shu6=shu1-shu2-shu4+shu5;System.out.println(shu1+"-"+shu2+"-"+shu4+"+"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 4:shu6=shu1+shu2-shu4-shu5;
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"-"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 5:shu6=shu1+shu2-shu4+shu5;
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 6:shu6=shu1+shu2-shu4+shu5;
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 7:shu6=shu1+shu2-shu4+shu5+shu9;
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"+"+shu5+"+"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 8:shu6=shu1+shu2-shu4-shu5-shu9;
	daan=String.valueOf(shu6);daan1=daan; 
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"-"+shu5+"-"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 9:shu6=shu1+shu2+shu4+shu5+shu9;
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"+"+shu4+"+"+shu5+"+"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 10:shu6=shu1-shu2-shu4+shu5+shu9;
	daan=String.valueOf(shu6);daan1=daan; 
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"+"+shu5+"+"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
	case 11:shu6=shu1-shu2-shu4+shu5*shu9;
	daan=String.valueOf(shu6);daan1=daan; 
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"+"+shu5+"¡Á"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break; 
	case 12:
		if(shu7>=0&&shu8>=0)
		{
		shu6=shu7+shu8;System.out.println(shu7+"+"+shu8+"=");daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"+"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7<0&&shu8>=0)
		{
			shu6=(shu7)+shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]="("+shu7+")"+"+"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7>=0&&shu8<0)
		{
		shu6=shu7+(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]="("+shu7+")"+"+"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7<0&&shu8<0)
		{
		shu6=(shu7)+(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"+"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
	    case 13:
		if(shu7>=0&&shu8>=0)
		{
			shu6=shu7-shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]=shu7+"-"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7<0&&shu8>=0)
		{
			shu6=(shu7)-shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]="("+shu7+")"+"-"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7>=0&&shu8<0)
		{
		shu6=shu7-(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]="("+shu7+")"+"-"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7<0&&shu8<0)
		{
		shu6=(shu7)-(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"-"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
	    case 14:
		if(shu7>=0&&shu8>=0)
		{
			shu6=shu7*shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]=shu7+"¡Á"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7<0&&shu8>=0)
		{
			shu6=(shu7)*shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]="("+shu7+")"+"¡Á"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7>=0&&shu8<0)
		{
		shu6=shu7*(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]="("+shu7+")"+"¡Á"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}
		else if(shu7<0&&shu8<0)
		{
		shu6=(shu7)*(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"¡Á"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;intorfloat=0;break;
		}  
	    case 15:shu20=shu19/shu18+shu17/shu16+shu15/shu14;
	    
	    daan=String.valueOf(df.format(shu20));daan1=daan;
		gongsi_daan_daan1[0]=""+shu19+"¡Â"+shu18+"+"+shu17+"¡Â"+shu16+"+"+shu15+"¡Â"+shu14+"=";  
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=1;
		break;
		
		
	    case 16:shu20=shu19/shu18-shu17/shu16+shu15/shu14;
	    
	    daan=String.valueOf(df.format(shu20));daan1=daan;
	    gongsi_daan_daan1[0]=""+shu19+"¡Â"+shu18+"-"+shu17+"¡Â"+shu16+"+"+shu15+"¡Â"+shu14+"=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=1;
		break;
	    case 17:shu20=shu19/shu18-shu17/shu16-shu15/shu14;
	    daan=String.valueOf(df.format(shu20));daan1=daan;
	    gongsi_daan_daan1[0]=""+shu19+"¡Â"+shu18+"-"+shu17+"¡Â"+shu16+"-"+shu15+"¡Â"+shu14+"=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=1;
		break;
	    
	    case 18:shu20=shu19/shu18+(shu17/shu16)*(shu15/shu14);
	    daan=String.valueOf(df.format(shu20));daan1=daan;
	    gongsi_daan_daan1[0]=""+shu19+"¡Â"+shu18+"+("+shu17+"¡Â"+shu16+")*("+shu15+"¡Â"+shu14+")=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=1;
		break;
	    
	    case 19:shu20=(shu19/shu18)*(shu17/shu16)*(shu15/shu14);
	    daan=String.valueOf(df.format(shu20));daan1=daan;
	    gongsi_daan_daan1[0]="("+shu19+"¡Â"+shu18+")¡Á("+shu17+"¡Â"+shu16+")¡Á("+shu15+"¡Â"+shu14+")=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=1;
		break;
	    
	    case 20:shu6=shu2-shu3*shu4-shu5;
	    daan=String.valueOf(shu6);daan1=daan;
	    gongsi_daan_daan1[0]=""+shu2+"-"+shu3+"¡Á"+shu4+"-"+shu5+"=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=0;break;
	    
	    case 21:shu6=shu2+shu3*shu4+shu5;
	    daan=String.valueOf(shu6);daan1=daan;
	    gongsi_daan_daan1[0]=""+shu2+"+"+shu3+"¡Á"+shu4+"+"+shu5+"=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=0;break;
		
	    case 22:shu6=shu2-shu3*shu4+shu5;
	    daan=String.valueOf(shu6);daan1=daan;
	    gongsi_daan_daan1[0]=""+shu2+"-"+shu3+"¡Á"+shu4+"+"+shu5+"=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=0;break;
	    case 23:shu6=(shu21-shu22)*(shu23+shu24);
	    daan=String.valueOf(shu6);daan1=daan;
	    gongsi_daan_daan1[0]="("+shu21+"-"+shu22+")¡Á("+shu23+"+"+shu24+")=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=0;break;
	    case 24:shu6=(shu21+shu22)*(shu23+shu24);
	    daan=String.valueOf(shu6);daan1=daan;
	    gongsi_daan_daan1[0]="("+shu21+"+"+shu22+")¡Á("+shu23+"+"+shu24+")=";    
		gongsi_daan_daan1[1]=daan;  
		gongsi_daan_daan1[2]=daan1;
		intorfloat=0;break;	
	}
	    return  gongsi_daan_daan1;
	}
	
	public int defineFloat(){
		
		return intorfloat;
	}
}
