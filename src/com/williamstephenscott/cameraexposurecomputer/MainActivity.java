package com.williamstephenscott.cameraexposurecomputer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import java.lang.Math;

public class MainActivity extends Activity {
	
	private int isoValue;
	private int[] isoOptions = new int[] {100, 200, 400, 800, 1600, 3200};
	
	private double shutterSpeedValue;
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
	
	private String evString;
	private int evValue;
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
	
	private double fstopValue;
	private double[] fstopOptions = new double[]
			{
				2,
				2.8,
				4,
				5.6,
				8,
				11,
				16,
				22,
				32,
				45,
				64
			};
	
	private int exposureValue;
	private double exposureValueDouble;
	private double cdpm2 =  Math.pow(2, (evValue - 3));
	
///method for updating exposure
	//paste this into code:
	//updateExposure(fstopValue, shutterSpeedValue, isoValue, cdpm2);
	private void updateExposure(double fstopValue, double shutterSpeedValue, int isoValue, double cdpm2) 
	{
		cdpm2 = Math.pow(2, (evValue - 3));
	//calculate exposure value
		double exposure1 = (((12.5 * (Math.pow(fstopValue, 2))) / (shutterSpeedValue * isoValue)) - cdpm2);
	//convert exposure1 to EV equivalent
		exposureValueDouble = (-1 * (((Math.log (cdpm2 + exposure1) / (Math.log(2.0))) + 3.0) - ((Math.log(cdpm2) / Math.log(2.0)) + 3.0))); 
		System.out.println(Math.round(exposureValueDouble));
		int exposureValueInt = (int) (Math.round(exposureValueDouble));
	//update exposureTextView		
		TextView exposureValueText = (TextView) findViewById(R.id.exposureTextView);
		exposureValueText.setText("" + exposureValueInt);
		return;
		//return exposureValueDouble;
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
			updateExposure(fstopValue, shutterSpeedValue, isoValue, cdpm2);
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
							(1f / 2f),
							(1f / 4f),
							(1f / 8f),
							(1f / 15f),
							(1f / 30f),
							(1f / 60f),
							(1f / 125f),
							(1f / 250f),
							(1f / 500f),
							(1f / 1000f)
						};
				
				shutterSpeedString = shutterSpeedOptions[progress];
				shutterSpeedValue = shutterSpeedFloats[progress]; 
			
				//refresh
				TextView shutterSpeedValueText = (TextView) findViewById(R.id.shutterSpeedTextView);
				shutterSpeedValueText.setText(shutterSpeedString);
				updateExposure(fstopValue, shutterSpeedValue, isoValue, cdpm2);
			
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
			updateExposure(fstopValue, shutterSpeedValue, isoValue, cdpm2);
			}
		});
	
	//create evSeekBar
		SeekBar evSeekBar = (SeekBar) findViewById(R.id.evSeekBar);
		evSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
		{

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) 
			{
			evString = evOptions[progress];
			evValue = (progress - 2);	
			TextView evValueText = (TextView) findViewById(R.id.evTextView);
			evValueText.setText(evString);
			updateExposure(fstopValue, shutterSpeedValue, isoValue, cdpm2);
			};

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
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