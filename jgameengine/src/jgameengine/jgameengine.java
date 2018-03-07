package jgameengine;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

//update
public class jgameengine extends JFrame {
	private static final long serialVersionUID = 1L;
	jgameengine() {
		super("demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(450, 450);
		setVisible(true);
	}
	
	static double[][] points = new double[3][2];
	static Color c;
	static object obj;
	static camera cam;
	
	//minimal x to be seen is 7
	//minimal y to be seen is 30
	//amount of elements must be three
	private void fillTri(Graphics g) {
		int[] xPoints = { (int)(points[0][0] + 7), (int)(points[1][0] + 7), (int)(points[2][0] + 7) };
		int[] yPoints = { (int)(points[0][1] + 30), (int)(points[1][1] + 30), (int)(points[2][1] + 30) };
		System.out.println(xPoints[0] + " " + xPoints[1] + " " + xPoints[2]);
		System.out.println(yPoints[0] + " " + yPoints[1] + " " + yPoints[2]);
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		fillTri(g);
	}
	
	public static void main(String[] arguments) {
		camera ca = new camera(3.0, 1.0, 1.0, 90);
		cube cu = new cube(2.0, 0.0, 2.0);
		persobj po = new persobj(cu.vertices.length);
		obj = cu;
		c = Color.black;
		cam = ca;
		cu.updatePos();
		po = ca.updatePers(cu);
		points[0] = po.vertices[0];
		for(int i = 1; i < (po.vertices.length - 1); i++) {
			points[1] = po.vertices[i];
			points[2] = po.vertices[(i + 1)];
		}
		@SuppressWarnings("unused")
		jgameengine ge = new jgameengine();
	}
}