package jgameengine;

//update
//basic structure of every class in game engine
class structure {
    //standard and only type of collision is mesh collision
    //game constants(players, enemies, etc.) can go through the collision
    //but collision can still make an event occur or something like that
    //Invisible
    final int COLLISION_INV = 2;
    //game constants cannot go through the collision
    //Visible
    final int COLLISION_VIS = 3;
    
    public double calcMagnitude(matrixV mat) {
	    	double magnitude = (mat.xarr * mat.xarr) + (mat.yarr * mat.yarr) + (mat.zarr * mat.zarr);
	    	magnitude = Math.sqrt(magnitude);
	    	return magnitude;
    }
    
    int objNum = 0;
    object[] objs;
    //call this function one time when the all the objects are initialized
    public void initObjs() {
    		objs = new object[objNum];
    }
    
    //return the smallest magnitude of an object
    public double sMagnitudeFind(object obj) {
    		double[] array = new double[obj.vertices.length];
    		for(int i = 0; i < array.length; i++) {
    			array[i] = obj.vertices[i].mat.magnitude;
    		}
    		int leftStart = 0;
    		int rightEnd = obj.vertices.length - 1;
    		mergesort(array, leftStart, rightEnd);
    		return array[0];
    }
    
    private double[] mergesort(double[] array, int leftStart, int rightEnd) {
    		double[] temp = new double[(int)(array.length / 2 + 0.5)];
    		double[] temp2 = new double[array.length / 2];
    		if(array.length == 2 || array.length == 3) {
	    		for(int i = 0; i < array.length; i++) {
	    			if(i <= (array.length / 2 + 0.5)) {
	    				temp[i] = array[i];
	    			} else if(i > (array.length / 2 + 0.5)) {
	    				temp2[i] = array[i];
	    			}
	    		}
	    		mergesort(temp, 0, (temp.length - 1));
	    		mergesort(temp2, 0, (temp2.length - 1));
    		}
		array = mergehalves(temp, temp2, array);
		return array;
    }
    
    private int index = 0;
    private double[] mergehalves(double[] temp, double[] temp2, double[] array) {
    		double[] ret = new double[array.length];
    		int left = temp. length - 2;
		int right = temp2.length - 2;
		while(left <= temp.length - 1 && right <= temp2.length - 1) {
			if(temp[left] >= temp2[right]) {
				ret[index] = temp[left];
				left++;
			} else {
				ret[index] = temp2[right];
				right++;
			}
			index++;
		}
		
		return array;
    }
    
    //return the largest magnitude of an object
    public int gMagnitudeFind(object obj) {
    		return 0;
    }
    
  //add own matrix by another
  	public matrixV addMat(matrixV mat, matrixV mat2) {
  		matrixV ret = new matrixV(0.0, 0.0, 0.0);
  		ret.xarr = mat2.xarr + mat.xarr;
  		ret.yarr = mat2.yarr + mat.yarr;
  		ret.zarr = mat2.zarr + mat.zarr;
  		ret.magnitude = this.calcMagnitude(ret);
  		return ret;
  	}
  	
  	//multiply own matrix by another
  	public matrixV mulMat(matrixV mat, matrixV mat2) {
  		matrixV ret = new matrixV(0.0, 0.0, 0.0);
  		double[] sub = new double[3];
  		sub[0] = mat2.xarr * mat.xarr;
  		sub[1] = mat2.xarr * mat.yarr;
  		sub[2] = mat2.xarr * mat.zarr;
  		ret.xarr = sub[0] + sub[1] + sub[2];
  		sub[0] = mat2.yarr * mat.xarr;
  		sub[1] = mat2.yarr * mat.yarr;
  		sub[2] = mat2.yarr * mat.zarr;
  		ret.yarr = sub[0] + sub[1] + sub[2];
  		sub[0] = mat2.zarr * mat.xarr;
  		sub[1] = mat2.zarr * mat.yarr;
  		sub[2] = mat2.zarr * mat.zarr;
  		ret.zarr = sub[0] + sub[1] + sub[2];
  		return ret;
  	}
  	
  	public matrixV rotate(matrixV mat, int degrees) {
  		degrees = (int)Math.toRadians(degrees);
  		double x = (mat.xarr * Math.cos(degrees)) - (mat.yarr * Math.sin(degrees));
  		double y = (mat.xarr * Math.sin(degrees)) + (mat.yarr * Math.cos(degrees));
  		mat.xarr = x;
  		mat.yarr = y;
  		return mat;
  	}
}