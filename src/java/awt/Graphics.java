package java.awt;

import java.awt.image.BufferedImage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

public class Graphics {

	private final Canvas canvas;
	private final Paint fillPaint;
	private final Paint picturePaint;
	
	public Graphics(Canvas canvas)
	{
		this.canvas = canvas;
		this.fillPaint = new Paint();
		fillPaint.setStyle(Style.FILL);
		
		picturePaint = new Paint();
	}
	
	public void fillRect(int x, int y, int width, int height) {
		canvas.drawRect(x, y, x + width, y + height, fillPaint);
	}

	public void drawImage(BufferedImage image, int xo, int yo, int ww, int hh,
			Object object) {
		// TODO Auto-generated method stub
		canvas.drawBitmap(image.getData(), 0, ww, xo, yo, ww, hh, false, picturePaint);
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
