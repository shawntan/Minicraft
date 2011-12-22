package com.schneeloch.other;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.mojang.ld22.Game;
import com.mojang.ld22.InputHandler;
import com.mojang.ld22.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

/**
 * Adapted from lunar lander example
 * @author schneg
 *
 */
public class GameActivity extends Activity implements OnTouchListener {
	private GameView gameView;
	private GameThread gameThread;
	private Button up;
	private Button down;
	private Button left;
	private Button right;
	private Button attack;
	private Button menu;

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
		
		up = (Button)findViewById(R.id.buttonUp);
		down = (Button)findViewById(R.id.buttonDown);
		left = (Button)findViewById(R.id.buttonLeft);
		right = (Button)findViewById(R.id.buttonRight);
		attack = (Button)findViewById(R.id.buttonAttack);
		menu = (Button)findViewById(R.id.buttonMenu);
		
		up.setOnTouchListener(this);
		down.setOnTouchListener(this);
		left.setOnTouchListener(this);
		right.setOnTouchListener(this);
		attack.setOnTouchListener(this);
		menu.setOnTouchListener(this);
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

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction();
		if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_UP)
		{
			if (v == up)
			{
				gameThread.getInputHandler().keyEvent(InputHandler.UP, action == MotionEvent.ACTION_DOWN);
				return true;
			}
			if (v == down)
			{
				gameThread.getInputHandler().keyEvent(InputHandler.DOWN, action == MotionEvent.ACTION_DOWN);
				return true;
			}
			if (v == left)
			{
				gameThread.getInputHandler().keyEvent(InputHandler.LEFT, action == MotionEvent.ACTION_DOWN);
				return true;
			}
			if (v == right)
			{
				gameThread.getInputHandler().keyEvent(InputHandler.RIGHT, action == MotionEvent.ACTION_DOWN);
				return true;
			}
			if (v == attack)
			{
				gameThread.getInputHandler().keyEvent(InputHandler.ATTACK, action == MotionEvent.ACTION_DOWN);
				return true;
			}
			if (v == menu)
			{
				gameThread.getInputHandler().keyEvent(InputHandler.MENU, action == MotionEvent.ACTION_DOWN);
				return true;
			}
			
		}
		return false;
	}
}
