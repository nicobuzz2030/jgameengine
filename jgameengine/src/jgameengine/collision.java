package jgameengine;

class collision extends structure {
    collision(int cvType, object obj) {
        this.cvType = cvType;
        this.obj = obj;
        this.update();
    }
    //is it invisible or visible collision
    int cvType;
    //vertices
    object obj;
    //if touched
    boolean[] touched = new boolean[5];
    vector[] objVects = new vector[5];
    
    //setup vertices
    public void update() {
    	for(int i = 0; i < touched.length; i++)
    	{
	    	if(this.cvType == COLLISION_INV) {
	    		if(this.touched[i]) {
	    			
	    		}
	    	} else if(this.cvType == COLLISION_VIS) {
	    		if(this.touched[i]) {
	    			
	    			objVects[i].mat.magnitude = calcMagnitude(objVects[i].mat.xarr, objVects[i].mat.yarr, objVects[i].mat.zarr);
	    		}
	    	}
    	}
    }
    
    //checks if object has been touched
    public void touch() {
    	for(int i = 0; i < objVects.length; i++) {
    		if(obj.mPosition.mat.magnitude <= objVects[i].mat.magnitude) {
    			if(objVects[i].mat.magnitude <= obj.vertices[(obj.vertices.length - 1)].mat.magnitude) {
    				this.touched[i] = true;
    			} else {
    				this.touched[i] = false;
    			}
    		} else {
    			this.touched[i] = false;
    		}
    	}
    }
}