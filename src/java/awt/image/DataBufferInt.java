package java.awt.image;

public class DataBufferInt extends DataBuffer
{
	private final WritableRaster raster;
	public DataBufferInt(WritableRaster writableRaster) {
		raster = writableRaster;
	}

	public int[] getData() {
		return raster.getData();
	}

}
