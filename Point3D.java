import java.awt.geom.Point2D;

public class Point3D {
	private float x;
	private float y;
	private float z;

	public Point3D(float x, float y, float z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public String toString() {
		return new String(x + " " + y + " " + z);
	}

	public Point2D ortographicProjection(float scaleX, float scaleZ,
			float offsetX, float offsetZ) {
		float x = scaleX * this.x + offsetX;
		float y = scaleZ * this.z + offsetZ;
		return new Point2D.Float(x, y);
	}

	public Point2D myProjection(float wx, float wy, float scaleX, float scaleY) {
		float x = this.x + this.z * wx;
		float y = this.y + this.z * wy;
		return new Point2D.Float(x * scaleX, y * scaleY);
	}
}
