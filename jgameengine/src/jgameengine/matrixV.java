package jgameengine;

//a matrix for vectors specifically
class matrixV extends structure {
	matrixV(double xarr, double yarr, double zarr) {
		this.xarr = xarr;
		this.yarr = yarr;
		this.zarr = zarr;
		this.init = true;
		this.magnitude = calcMagnitude(this.xarr, this.yarr, this.zarr);
	}
	
	public void setup(double xarr, double yarr, double zarr) {
		if(!this.init) {
			this.xarr = xarr;
			this.yarr = yarr;
			this.zarr = zarr;
		}
	}
	
	//if constructor called
	boolean init;
	//the x part of the array
	double xarr;
	//the y part of the array
	double yarr;
	//the z part of the array
	double zarr;
	double magnitude;
	
	//add own matrix by another
	public matrixV addMat(matrixV mat) {
		matrixV ret = new matrixV(0.0f, 0.0f, 0.0f);
		ret.xarr = this.xarr + mat.xarr;
		ret.yarr = this.yarr + mat.yarr;
		ret.zarr = this.zarr + mat.zarr;
		return ret;
	}
	
	//subtract own matrix by another
	public matrixV subMat(matrixV mat) {
		matrixV ret = new matrixV(0.0f, 0.0f, 0.0f);
		ret.xarr = this.xarr - mat.xarr;
		ret.yarr = this.yarr - mat.yarr;
		ret.zarr = this.zarr - mat.zarr;
		return ret;
	}
	
	//multiply own matrix by another
	public matrixV mulMat(matrixV mat) {
		matrixV ret = new matrixV(0.0f, 0.0f, 0.0f);
		double[] sub = new double[3];
		sub[0] = this.xarr * mat.xarr;
		sub[1] = this.xarr * mat.yarr;
		sub[2] = this.xarr * mat.zarr;
		ret.xarr = sub[0] + sub[1] + sub[2];
		sub[0] = this.yarr * mat.xarr;
		sub[1] = this.yarr * mat.yarr;
		sub[2] = this.yarr * mat.zarr;
		ret.yarr = sub[0] + sub[1] + sub[2];
		sub[0] = this.zarr * mat.xarr;
		sub[1] = this.zarr * mat.yarr;
		sub[2] = this.zarr * mat.zarr;
		ret.zarr = sub[0] + sub[1] + sub[2];
		return ret;
	}
}