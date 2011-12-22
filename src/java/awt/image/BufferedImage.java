package java.awt.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;

public class BufferedImage {
	private final Bitmap bitmap;
	
	public BufferedImage(int width, int height, int typeIntRgb) {
		bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
	}

	public BufferedImage(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public static final int TYPE_INT_RGB = 1;

	public WritableRaster getRaster() {
		return new WritableRaster(this);
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return bitmap.getWidth();
	}

	
	public int getHeight()
	{
		return bitmap.getHeight();
	}

	public int[] getRGB(int i, int j, int width, int height, Object object,
			int k, int width2) {
		return getData();
	}

	public int[] getData() {
		int[] pixels = new int[bitmap.getWidth() * bitmap.getHeight()];
		bitmap.getPixels(pixels, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
		return pixels;
	}
}
