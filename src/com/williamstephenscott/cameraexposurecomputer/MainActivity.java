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
	}
	
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
}