package com.williamstephenscott.cameraexposurecomputer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private int isoValue;
	private int[] isoOptions = new int[] {100, 200, 400, 800, 1600, 3200};
	
	private float shutterSpeedValue;
	private String shutterSpeedString;
	private String[] shutterSpeedOptions = new String[] 
			{
			"4",
			"2",
			"1",
			"1/2",
			"1/4",
			"1/8",
			"1/15",
			"1/30",
			"1/60",
			"1/125",
			"1/250",
			"1/500",
			"1/1000"
			};
	
	private float fstopValue;
	private float[] fstopOptions = new float[]
			{
				2f,
				2.8f,
				4f,
				5.6f,
				8f,
				11f,
				16f,
				22f,
				32f,
				45f,
				64f
			};
	
	private int evValue;
	private String evString;
	private String[] evOptions = new String[]
			{
			"-2 - Full moonlight",
			"-1",
			"0",
			"1",
			"2 - distant lit buildings",
			"3",
			"4 - Christmas Tree Lights, floodlights",
			"5 - Night traffic",
			"6 - Indoor Party",
			"7 - Amusement parks, offices",
			"8 - Flourescent lighting, streetlights, circus",
			"9 - Neon and signage, stage shows",
			"10 - After sunset",
			"11 - Shady",
			"12 - Overcast, at sunset",
			"13 - Cloudy",
			"14 - Hazy",
			"15 - Sunny",
			"16 - Sand and Snow"
			};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//create isoSeekBar and listen to it
		SeekBar isoSeekBar = (SeekBar) findViewById(R.id.isoSeekBar);
		isoSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()

		{
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) 
			{
			
			isoValue = isoOptions[progress];
			//refresh
			TextView isoValueText = (TextView) findViewById(R.id.isoTextView);
			isoValueText.setText("" + isoValue );
			}
		});
	//create shutterSpeedSeekBar and listen to it
		SeekBar shutterSpeedSeekBar = (SeekBar) findViewById(R.id.shutterSpeedSeekBar);
		shutterSpeedSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		{
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) 
			{
			float[] shutterSpeedFloats = new float[] 
						{
							4f,
							2f,
							1f,
							(1 / 2),
							(1 / 4),
							(1 / 8),
							(1 / 15),
							(1 / 30),
							(1 / 60),
							(1 / 125),
							(1 / 250),
							(1 / 500),
							(1 / 1000)
						};
				
				shutterSpeedString = shutterSpeedOptions[progress];
				shutterSpeedValue = shutterSpeedFloats[progress]; 
			
				//refresh
				TextView shutterSpeedValueText = (TextView) findViewById(R.id.shutterSpeedTextView);
				shutterSpeedValueText.setText(shutterSpeedString);
				
			
			}
			
		});
	
	//create fstopSeekBar
		SeekBar fstopSeekBar = (SeekBar) findViewById(R.id.fstopSeekBar);
		fstopSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
		
		{
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) 
			{
			fstopValue = fstopOptions[progress];
			TextView fstopTextView = (TextView) findViewById(R.id.fstopTextView);
			fstopTextView.setText("" + fstopValue);
			
			}
		});
	
	//create evSeekBar
		SeekBar evSeekBar = (SeekBar) findViewById(R.id.evSeekBar);
		evSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) 
			{
				evString = evOptions[progress];
				evValue = (progress - 2);
				TextView evTextView = (TextView) findViewById(R.id.evTextView);
				evTextView.setText(evString);
			}
			
			
		});
	}
	
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}