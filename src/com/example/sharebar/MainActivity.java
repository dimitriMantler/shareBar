package com.example.sharebar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Bitmap;

import com.example.sharebar.ShareBar.Size;

public class MainActivity extends Activity implements OnSeekBarChangeListener{

	SeekBar sbGreen;
	SeekBar sbYellow;
	ImageView ivWide;
	TextView tv1;
	Bitmap b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); 
		tv1=(TextView)findViewById(R.id.textView1);
		sbGreen=(SeekBar)findViewById(R.id.seekBar1);
		sbGreen.setOnSeekBarChangeListener(this);
		sbYellow=(SeekBar)findViewById(R.id.seekBar2);
		sbYellow.setOnSeekBarChangeListener(this);
		ivWide=(ImageView)findViewById(R.id.ivWide);
	}

	@Override 
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		int pg=sbGreen.getProgress();
		int py=sbYellow.getProgress();
		int whole=pg+py;
		if(whole>100){
			if(seekBar==sbGreen){
				sbYellow.setProgress(sbYellow.getProgress()-(whole-100));
			}
			else{
				sbGreen.setProgress(sbGreen.getProgress()-(whole-100));
			}
		}
		Bitmap b=ShareBar.createShareBar(this, pg, py, 0, Size.WIDE);
		ivWide.setImageBitmap(b);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
	}

}
