package jgameengine;

//update
class collision extends structure {
    collision(int cvType, object obj) {
        this.cvType = cvType;
        this.obj = obj;
        this.touched = new boolean[objNum - 1];
    }
    
    //is it invisible or visible collision
    int cvType;
    //vertices
    object obj;
    boolean[] touched;
    //the greatest magnitude of obj
    int gMagnitude;
    //the smallest object in obj
    int sMagnitude;
    
    //setup vertices
    public void update() {
	    	for(int i = 0; i < touched.length; i++) {
		    	if(this.cvType == COLLISION_INV) {
		    		if(this.touched[i]) {
		    			//do something. will be plugged in through the actual game code
		    		}
		    	} else if(this.cvType == COLLISION_VIS) {
		    		if(this.touched[i]) {
		    			
		    			//objs[i].vertices[0].mat.magnitude = calcMagnitude(objs[i].vertices[0].mat);
		    		}
		    	}
	    	}
    }
    
    //checks if object has been touched
    public void touch() {
	    	for(int i = 0; i < (objs.length - 1); i++) {
	    		for(int x = 0; x < objs[i].vertices.length; i++) {
		    		if(obj.mPosition.mat.magnitude <= objs[i].vertices[x].mat.magnitude) {
		    			if(objs[i].vertices[x].mat.magnitude <= obj.vertices[(obj.vertices.length - 1)].mat.magnitude) {
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
}