public class Edge {
	int a;
	int b;
	float c;

	public Edge(int a, int b, float c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public float getC() {
		return c;
	}

	public String toString() {
		return new String(a + " " + b + " " + c);
	}

}
