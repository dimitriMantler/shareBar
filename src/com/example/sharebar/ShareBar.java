package com.example.sharebar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;


public class ShareBar {

	public enum Size{
		WIDE,SMALL
	}
	
	static Bitmap b=null;
	
	public static Bitmap createShareBar(Context con,float good, float med, float bad, Size size){
		switch(size){
		case WIDE:
			b=BitmapFactory.decodeResource(con.getResources(), 
					R.drawable.empty_bar_wide).copy(Bitmap.Config.ARGB_8888, true);
			break;
		case SMALL:
			b=BitmapFactory.decodeResource(con.getResources(), 
					R.drawable.empty_bar).copy(Bitmap.Config.ARGB_8888, true);
			break;
		}
		
		if(good>0||med>0||bad>0){
			Bitmap shareGood=BitmapFactory.decodeResource(con.getResources(), R.drawable.share_good);
			Bitmap shareMedium=BitmapFactory.decodeResource(con.getResources(), R.drawable.share_medium);
			Bitmap shareBad=BitmapFactory.decodeResource(con.getResources(), R.drawable.share_bad);
			
			Bitmap iconGood=BitmapFactory.decodeResource(con.getResources(), R.drawable.icon_good_inverse);
			Bitmap iconMedium=BitmapFactory.decodeResource(con.getResources(), R.drawable.icon_medium_inverse);
			Bitmap iconBad=BitmapFactory.decodeResource(con.getResources(), R.drawable.icon_bad_inverse);
			
			Paint p=new Paint();
			Canvas c=new Canvas(b);
			
			int green=(int)(good*(((float)b.getWidth()-2)/100));
			int yellow=(int)(med*(((float)b.getWidth()-2)/100));
			
			for(int x=0;x<green;x++){
				c.drawBitmap(shareGood, x+1, 0, p);
			}
			
			for(int x=(int)green;x<green+yellow;x++){
				c.drawBitmap(shareMedium, x+1, 0, p);
			}
			
			for(int x=(int)(green+yellow);x<b.getWidth()-2;x++){
				c.drawBitmap(shareBad, x+1, 0, p);
			}
			
			if(green>=iconGood.getWidth())
				c.drawBitmap(iconGood, (green-iconGood.getWidth())/2+1, 
						(b.getHeight()-iconGood.getHeight())/2, new Paint());
			if(yellow-2>=iconMedium.getWidth())
				c.drawBitmap(iconMedium, (green+(yellow-iconMedium.getWidth())/2)+1, 
						(b.getHeight()-iconMedium.getHeight())/2, new Paint());
			if(b.getWidth()-green-yellow-2-2>=iconBad.getWidth())
				c.drawBitmap(iconBad, (green+yellow+((b.getWidth()-green-yellow-2)-iconBad.getWidth())/2)+1, 
						(b.getHeight()-iconBad.getHeight())/2, new Paint());
		}
		return b;
	}
	
}


