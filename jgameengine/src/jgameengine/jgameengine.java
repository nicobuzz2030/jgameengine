package jgameengine;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class jgameengine extends JFrame {
	private static final long serialVersionUID = 1L;
	jgameengine() {
		super("demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(100, 100);
		setSize(450, 450);
		setVisible(true);
	}
	
	//minimal x to be seen is 7
	//minimal y to be seen is 30
	//amount of elements must be three
	@SuppressWarnings("unused")
	private void fillTri(Graphics g, vector[] points) {
		int[] xPoints = { (int)points[0].mat.xarr, (int)points[1].mat.xarr, (int)points[2].mat.xarr };
		int[] yPoints = { (int)points[0].mat.yarr, (int)points[1].mat.yarr, (int)points[2].mat.yarr };
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.blue);
	}
	
	public static void main(String[] arguments) {
		@SuppressWarnings("unused")
		jgameengine ge = new jgameengine();
		//cube c = new cube(2.0f, 2.0f, 2.0f);
	}
}