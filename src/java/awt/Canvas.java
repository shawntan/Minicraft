package java.awt;

import java.awt.image.BufferStrategy;

import com.schneeloch.other.GameView;

public class Canvas {
	private GameView gameView;
	
	public void setGameView(GameView gameView)
	{
		this.gameView = gameView;
		
	}
	
	protected boolean hasFocus()
	{
		return true;
	}
	
	protected int getWidth()
	{
		
	}
	
	protected int getHeight()
	{
		
	}
	
	protected BufferStrategy getBufferStrategy()
	{
		
	}
	
	protected BufferStrategy createBufferStrategy(int x)
	{
		return new BufferStrategy();
	}
	
	protected void requestFocus()
	{
		
	}
}
