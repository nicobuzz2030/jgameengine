package jgameengine;

//update
class camera extends structure {
	camera(double xpos, double ypos, double zpos, int degrees) {
		this.position = new vector(xpos, ypos, zpos);
		this.degrees = degrees;
	}
	
	vector position;
	int degrees;
	
	//first element is the x-position
	//second element is the y-position
	//calculating perspective
	public persobj updatePers(object obj) {
		persobj po = new persobj(obj.vertices.length);
		for(int i = 0; i < obj.vertices.length; i++) {
			po.vertices[i][0] = (position.mat.xarr - obj.vertices[i].mat.xarr) / (position.mat.zarr - obj.vertices[i].mat.zarr);
			po.vertices[i][0] = position.mat.xarr - po.vertices[i][0];
			po.vertices[i][1] = (position.mat.yarr - obj.vertices[i].mat.yarr) / (position.mat.zarr - obj.vertices[i].mat.zarr);
			po.vertices[i][1] = position.mat.xarr - po.vertices[i][1];
		}
		return po;
	}
}