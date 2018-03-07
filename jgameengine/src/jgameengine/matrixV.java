package jgameengine;

//update
//a matrix for vectors specifically
class matrixV extends structure {
	matrixV(double xarr, double yarr, double zarr) {
		this.xarr = xarr;
		this.yarr = yarr;
		this.zarr = zarr;
		this.magnitude = calcMagnitude(this);
	}
	
	//can be used to change the matrix or set it up when
	//the constructor failed to be called
	public void change(double xarr, double yarr, double zarr) {
		this.xarr = xarr;
		this.yarr = yarr;
		this.zarr = zarr;
		this.magnitude = calcMagnitude(this);
	}
	
	//the x part of the array
	double xarr;
	//the y part of the array
	double yarr;
	//the z part of the array
	double zarr;
	double magnitude;
}