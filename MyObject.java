import java.util.List;

public class MyObject {
	private int id;
	private List<Point3D> points;
	private List<Edge> edges;

	public int getEdgesSize() {
		return edges.size();
	}

	public float getTension(int i) {
		return edges.get(i).getC();
	}

	public Point3D getPointA(int wichEdge) {
		return points.get(edges.get(wichEdge).getA());
	}

	public Point3D getPointB(int whichEdge) {
		return points.get(edges.get(whichEdge).getB());
	}

	public MyObject(int id, List<Point3D> points, List<Edge> lines) {
		super();
		this.id = id;
		this.points = points;
		this.edges = lines;
	}

	public String toString() {
		String result = new String();
		result += "ID\n";
		result += id + "\n";
		Integer.toString(1);
		result += "Points3D\n";
		for (int i = 0; i < points.size(); i++) {
			result += points.get(i).toString() + "\n";
		}
		result += "Edges\n";
		for (int i = 0; i < edges.size(); i++) {
			result += edges.get(i).toString() + "\n";
		}
		return result;
	}

}
