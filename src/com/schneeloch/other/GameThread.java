package com.schneeloch.other;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.mojang.ld22.Game;
import com.mojang.ld22.InputHandler;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;

/**
 * Adapted from lunar lander example
 * @author schneg
 *
 */
public class GameThread extends Thread {
	private final SurfaceHolder surfaceHolder;
	private final Context context;
	private final Handler handler;
	private InputHandler inputHandler;
	
	private boolean run;
	
	public static final int STATE_PAUSE = 1;
	public static final int STATE_READY = 2;
	public static final int STATE_RUNNING = 3;

	private int canvasHeight = -1;
	private int canvasWidth = -1;
	
	private int mode;
	
	public GameThread(SurfaceHolder surfaceHolder, Context context, Handler handler)
	{
		this.surfaceHolder = surfaceHolder;
		this.context = context;
		this.handler = handler;
	}
	
	public void doStart()
	{
		synchronized (surfaceHolder) {
			setState(STATE_RUNNING);
		}
	}
	
	public void pause()
	{
		synchronized (surfaceHolder) {
			if (mode == STATE_RUNNING)
			{
				setState(STATE_PAUSE);
			}
		}
	}
	
	public synchronized void restoreState(Bundle savedState)
	{
		synchronized (surfaceHolder) {
			setState(STATE_PAUSE);
			
			// load state here
		}
		
	}
	
	
	
	@Override
	public void run() {
		Game game = new Game();
		game.start();
		inputHandler = game.getInputHandler();
		
		game.startRun(context);
		while (run)
		{
			Canvas canvas = null;
			try
			{
				canvas = surfaceHolder.lockCanvas(null);
				synchronized (surfaceHolder) {
					if (mode == STATE_RUNNING)
					{
						// update game state here
						game.iterate(context, canvas);
						//game.doDraw(canvas);
					}
				}
				
			}
			finally
			{
				if (canvas != null)
				{
					surfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}
	
	public Bundle saveState(Bundle map)
	{
		synchronized (surfaceHolder) {
			if (map != null)
			{
				//store all state in map
			}
		}
		return map;
	}
	
	public void setRunning(boolean b)
	{
		run = b;
	}
	
	public void setState(int state)
	{
		synchronized (surfaceHolder) {
			setState(state, null);
		}
	}
	
	public void setState(int state, CharSequence message)
	{
		synchronized (surfaceHolder) {
			mode = state;
			
			if (mode == STATE_RUNNING)
			{
				Message msg = handler.obtainMessage();
				Bundle bundle = new Bundle();
				bundle.putString("text", "");
				bundle.putInt("viz", View.INVISIBLE);
				msg.setData(bundle);
				handler.sendMessage(msg);
			}
			else
			{
				Message msg = handler.obtainMessage();
                Bundle b = new Bundle();
                b.putString("text", "");
                b.putInt("viz", View.VISIBLE);
                msg.setData(b);
                handler.sendMessage(msg);				
			}
		}
	}
	
	public void setSurfaceSize(int width, int height)
	{
		synchronized (surfaceHolder) {
			canvasWidth = width;
			canvasHeight = height;
			
			//resize other stuff if needed
		}
		
	}
	
	public void unpause()
	{
		setState(STATE_RUNNING);
	}

	public InputHandler getInputHandler()
	{
		return inputHandler;
	}
}
