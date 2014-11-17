import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Framstick {

	private List<MyObject> objects;

	public List<MyObject> getObjects() {
		return objects;
	}

	public void print() {
		for (int i = 0; i < objects.size(); i++) {
			System.out.println(objects.get(i).toString());
		}
	}

	public String getLine(BufferedReader br) throws IOException {
		String str = br.readLine();
		if (str.startsWith("#") || str.matches("")) {
			return null;
		} else {
			return str;
		}
	}

	public void load(String filepath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		objects = new ArrayList<MyObject>();
		String line;
		while (br.ready()) {
			if ((line = getLine(br)) == null) {
				continue;
			}
			String[] paramsArray = line.split(" ");
			int id = Integer.parseInt(paramsArray[0]);
			int edgesCount = Integer.parseInt(paramsArray[1]);
			int pointsCount = Integer.parseInt(paramsArray[2]);
			List<Point3D> points3d = new ArrayList<Point3D>();
			for (int i = 0; i < pointsCount; ++i) {
				line = getLine(br);
				String[] pointsArray = line.split(" ");
				Point3D point = new Point3D(Float.parseFloat(pointsArray[0]),
						Float.parseFloat(pointsArray[1]),
						Float.parseFloat(pointsArray[2]));
				points3d.add(point);
			}
			List<Edge> edges = new ArrayList<Edge>();
			for (int i = 0; i < edgesCount; ++i) {
				line = getLine(br);
				String[] edgesArray = line.split(" ");
				Edge edge = new Edge(Integer.parseInt(edgesArray[0]),
						Integer.parseInt(edgesArray[1]),
						Float.parseFloat(edgesArray[2]));
				edges.add(edge);
			}
			MyObject object = new MyObject(id, points3d, edges);
			objects.add(object);
		}
		br.close();
	}
}
