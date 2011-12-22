package java.awt.image;

public class WritableRaster {
	private final BufferedImage image;
	
	public WritableRaster(BufferedImage bufferedImage) {
		image = bufferedImage;
	}

	public DataBuffer getDataBuffer() {
		return new DataBufferInt(this);
	}

	public int[] getData() {
		return image.getData();
	}

}
