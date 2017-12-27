package jgameengine;

class vector {
    vector(float xpos, float ypos, float zpos) {
        this.mat.setup(xpos, ypos, zpos);
    }
    
    float magnitude;
    matrixV mat;
    
    public matrixV addMat(matrixV mat) {
    	matrixV ret;
		ret = this.mat.addMat(mat);
		return ret;
	}
	
	public matrixV subMat(matrixV mat) {
		matrixV ret;
		ret = this.mat.subMat(mat);
		return ret;
	}
	
	public matrixV mulMat(matrixV mat) {
		matrixV ret;
		ret = this.mat.mulMat(mat);
		return ret;
	}
}
