package com.schneeloch.other;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.mojang.ld22.Game;
import com.mojang.ld22.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * Adapted from lunar lander example
 * @author schneg
 *
 */
public class GameActivity extends Activity {
	private GameView gameView;
	private GameThread gameThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		
		gameView = (GameView)findViewById(R.id.surface);
		gameThread = gameView.getThread();
		
		if (savedInstanceState == null)
		{
			gameThread.setState(GameThread.STATE_READY);
			
		}
		else
		{
			gameThread.restoreState(savedInstanceState);
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		gameView.getThread().pause();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		
		gameThread.saveState(outState);
		
	}
}
