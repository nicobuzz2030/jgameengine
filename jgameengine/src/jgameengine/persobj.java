package jgameengine;

//update
//2d-object holding the 3d-object modified by perspective
class persobj {
	persobj(int len) {
		vertices = new double[len][2];
	}
	
	//2d-vertices: x-position, y-position
	double[][] vertices;
}
