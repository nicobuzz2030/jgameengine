package jgameengine;

//an object in the game
class object extends structure {
    /*
    put a constructor with this code in every object
    object(int xpos, int ypos, int zpos) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.zpos = zpos;
        this.behavior();
        this.vertices = new vertex[how many elements you want];
        int cvType = visible or invisible collision type;
        setup collision
        collision coll = new collision(this.cvType);
    }
    */
	//model position
	//will be the point closest to the origin 
    vector mPosition;
    //the scale
    float scale;
    //vertices
    vector[] vertices;
    //collision visibility type
    int cvType = COLLISION_INV;
    //operation for equation
    boolean[] operation = new boolean[3];
    
    //change the cvType to whatever other type of collision visibility
    public void changeCV(int cvType) {
    	this.cvType = cvType;
    }
    
    //how does the object setup its vertices
    public double[] updatePos() {
    	double[] ret = new double[1];
        //for(int i = 0; i < blah; i++) {
            //vertices[i].xpos = this.xpos + blah;
            //vertices[i].ypos = this.ypos + blah;
            //vertices[i].zpos = this.zpos + blah;
        //}
        //pretty good example of what will be done
        //can do anything in the function for the behavior
        //x - blah goes left of the object's x-position
        //x + blah does the exact opposite of x - blah
        //y - blah goes down below the object's y-position
        //y + blah does the exact opposite of y - blah
        //z - blah goes backward more toward the player than the object's 
        //z - position
        //z + blah does the exact opposite of z - blah
    	return ret;
    }
    
    //equation = xpos / ypos / zpos, + / -, scale
    //equation to calculate a point on an object
    //operation = which operation is it, + / -
    //1 is +, 0 is -
    //operation holds three elements
    //point - the specific point of the object that is being calculated
    //position - the position of the object
	protected vector equation(vector point, boolean[] operation, vector position) {
    	if(operation[0]) {
    		point.mat.xarr= position.mat.xarr + this.scale;
    	} else if(!operation[0]) {
    		point.mat.xarr = position.mat.xarr - this.scale;
    	}
    	
    	if(operation[1]) {
    		point.mat.yarr = position.mat.yarr + this.scale;
    	} else if(!operation[1]) {
    		point.mat.yarr = position.mat.yarr - this.scale;
    	}
    	
    	if(operation[2]) {
    		point.mat.zarr = position.mat.zarr + this.scale;
    	} else if(!operation[2]) {
    		point.mat.zarr = position.mat.zarr - this.scale;
    	}
	    return point;
    }
    
    //set operation one constant value
    //uses one boolean value for a vertex
	protected vector allEquation(vector point, boolean operation, vector position) {
    	boolean op[] = { operation, operation, operation };
		point = this.equation(point, op, position);
	    return point;
    }
	
	//function to give each array an element easily that isn't in the initializer line
    //boolean : takes three booleans
    //specifically for operation
    public boolean[] arrayOrganizerB(boolean ar[], boolean a, boolean b, boolean c) {
    	ar[0] = a;
    	ar[1] = b;
    	ar[2] = c;
    	return ar;
    }
}