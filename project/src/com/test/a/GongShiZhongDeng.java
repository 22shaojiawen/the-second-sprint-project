
package com.test.a;
public class GongShiZhongDeng {

	GongShiZhongDeng(){
			
	}
	
	
	public String[] four_number()
	{
		
		int shu=(int)(Math.random()*11+1);
		int shu1=(int)(Math.random()*10);
		int shu2=(int)(Math.random()*10);
		int shu4=(int)(Math.random()*10);
		int shu5=(int)(Math.random()*10);
		int shu9=(int)(Math.random()*10);
		int shu6;
		String daan;
		String daan1;
		String gongsi_daan_daan1[]=new String[3];
	switch(shu)
	{
	case 1:shu6=shu1+shu2+shu4+shu5;System.out.println(shu1+"+"+shu2+"+"+shu4+"+"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"+"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 2:shu6=shu1-shu2-shu4-shu5;System.out.println(shu1+"-"+shu2+"-"+shu4+"-"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"-"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break; 
	case 3:shu6=shu1-shu2-shu4+shu5;System.out.println(shu1+"-"+shu2+"-"+shu4+"+"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 4:shu6=shu1+shu2-shu4-shu5;System.out.println(shu1+"+"+shu2+"-"+shu4+"-"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"-"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 5:shu6=shu1+shu2-shu4+shu5;System.out.println(shu1+"+"+shu2+"-"+shu4+"+"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 6:shu6=shu1+shu2-shu4+shu5;System.out.println(shu1+"+"+shu2+"-"+shu4+"+"+shu5+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"+"+shu5+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 7:shu6=shu1+shu2-shu4+shu5+shu9;System.out.println(shu1+"+"+shu2+"-"+shu4+"+"+shu5+"+"+shu9+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"+"+shu5+"+"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 8:shu6=shu1+shu2-shu4-shu5-shu9;System.out.println(shu1+"+"+shu2+"-"+shu4+"-"+shu5+"-"+shu9+"=");
	daan=String.valueOf(shu6);daan1=daan; 
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"-"+shu4+"-"+shu5+"-"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 9:shu6=shu1+shu2+shu4+shu5+shu9;System.out.println(shu1+"+"+shu2+"+"+shu4+"+"+shu5+"+"+shu9+"=");
	daan=String.valueOf(shu6);daan1=daan;
	gongsi_daan_daan1[0]=shu1+"+"+shu2+"+"+shu4+"+"+shu5+"+"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 10:shu6=shu1-shu2-shu4+shu5+shu9;System.out.println(shu1+"-"+shu2+"-"+shu4+"+"+shu5+"+"+shu9+"=");
	daan=String.valueOf(shu6);daan1=daan; 
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"+"+shu5+"+"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
	case 11:shu6=shu1-shu2-shu4+shu5*shu9;System.out.println(shu1+"-"+shu2+"-"+shu4+"+"+shu5+"*"+shu9+"=");
	daan=String.valueOf(shu6);daan1=daan; 
	gongsi_daan_daan1[0]=shu1+"-"+shu2+"-"+shu4+"+"+shu5+"¡Á"+shu9+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break; 
	}
	return  gongsi_daan_daan1;
	}
	
	
	
	
	public String[] kuohao_gongsi()
	{
	int shu=(int)(Math.random()*3+1);
	
	int shu6;
	int shu7=(int)(Math.random()*201)-100,shu8=(int)(Math.random()*201)-100;
	String daan;
	String daan1;
	String gongsi_daan_daan1[]=new String[3];
	switch(shu)
	{
	case 1:
		
		if(shu7>=0&&shu8>=0)
		{
		shu6=shu7+shu8;System.out.println(shu7+"+"+shu8+"=");daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"+"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7<0&&shu8>=0)
		{
			shu6=(shu7)+shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]="("+shu7+")"+"+"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7>=0&&shu8<0)
		{
		shu6=shu7+(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]="("+shu7+")"+"+"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7<0&&shu8<0)
		{
		shu6=(shu7)+(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"+"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
			
	    case 2:
		if(shu7>=0&&shu8>=0)
		{
			shu6=shu7-shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]=shu7+"-"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7<0&&shu8>=0)
		{
			shu6=(shu7)-shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]="("+shu7+")"+"-"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7>=0&&shu8<0)
		{
		shu6=shu7-(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]="("+shu7+")"+"-"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7<0&&shu8<0)
		{
		shu6=(shu7)-(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"-"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		
	    case 3:
		if(shu7>=0&&shu8>=0)
		{
			shu6=shu7*shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]=shu7+"¡Á"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7<0&&shu8>=0)
		{
			shu6=(shu7)*shu8;daan=String.valueOf(shu6);daan1=daan;
			gongsi_daan_daan1[0]="("+shu7+")"+"¡Á"+shu8+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7>=0&&shu8<0)
		{
		shu6=shu7*(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]="("+shu7+")"+"¡Á"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}
		else if(shu7<0&&shu8<0)
		{
		shu6=(shu7)*(shu8);daan=String.valueOf(shu6);daan1=daan;
		gongsi_daan_daan1[0]=shu7+"¡Á"+"("+shu8+")"+"=";  gongsi_daan_daan1[1]=daan;  gongsi_daan_daan1[2]=daan1;break;
		}  
	}
	return  gongsi_daan_daan1;
	}
	
}
