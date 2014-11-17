import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class MyCanvas extends JComponent {
	private List<MyObject> objects;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;

	private static final long serialVersionUID = -8326903659037256901L;

	public MyCanvas(int width, int height, JTextField text1, JTextField text2,
			JTextField text3, JTextField text4, List<MyObject> objects) {
		this.setSize(width, height);
		this.objects = objects;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;
		this.text4 = text4;
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < objects.size(); i++) { // wszystkie obiekty i
			MyObject object = objects.get(i);
			for (int j = 0; j < object.getEdgesSize(); j++) { // wszystkie
																// krawedzie j
				g2.setPaint(getColor2(object.getTension(j)));
				Point3D a = object.getPointA(j);
				Point3D b = object.getPointB(j);
				// System.out.println(a.toString() + " " + b.toString());
				float wx = Float.parseFloat(text1.getText());
				float wy = Float.parseFloat(text2.getText());
				float scaleX = Float.parseFloat(text3.getText());
				float scaleY = Float.parseFloat(text4.getText());
				Point2D a2 = a.myProjection(wx, wy, scaleX, scaleY);
				Point2D b2 = b.myProjection(wx, wy, scaleX, scaleY);
				// Point2D a2 = a.ortographicProjection(scale, scale, offsetX,
				// offsetZ);
				// Point2D b2 = b.ortographicProjection(scale, scale, offsetX,
				// offsetZ);
				// System.out.println(a2.toString() + " " + b2.toString());
				g2.draw(new Line2D.Float(a2, b2));
			}
		}
		repaint();
	}

	public Color getColor2(float x) {
		float p = x * 3.0f;
		if (x <= 1.0f / 3.0f)
			return mixColors2(Color.red, Color.green, p);
		else if (x <= 2.0f / 3.0f)
			return mixColors2(Color.green, Color.blue, p);
		else
			return mixColors2(Color.blue, Color.red, p);
	}

	public Color mixColors2(Color c0, Color c1, float p) {
		while (p > 1.0f) {
			p -= 1.0f;
		}
		int red, green, blue;
		if (p < 0.5f) {
			red = (int) (c0.getRed() + c1.getRed() * p * 2);
			green = (int) (c0.getGreen() + c1.getGreen() * p * 2);
			blue = (int) (c0.getBlue() + c1.getBlue() * p * 2);
		} else {
			red = (int) (c0.getRed() * (1 - 2 * (p - 0.5f)) + c1.getRed());
			green = (int) (c0.getGreen() * (1 - 2 * (p - 0.5f)) + c1.getGreen());
			blue = (int) (c0.getBlue() * (1 - 2 * (p - 0.5f)) + c1.getBlue());
		}
		return new Color(red, green, blue);
	}
}
