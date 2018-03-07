package jgameengine;
import java.awt.Color;

//update
//an object in the game
class object extends structure {
    object(double xpos, double ypos, double zpos, double scale, int vectors) {
    		mPosition = new vector(xpos, ypos, zpos);
        this.scale = scale;
        this.vertices = new vector[vectors];
        for(int i = 1; i < vertices.length; i++) {
        		vertices[i] = new vector(0.0, 0.0, 0.0);
        }
        this.vertices[0] = this.mPosition;
        this.c = Color.white;
        ++objNum;
        oNum = objNum;
        //this.coll = new collision(this.cvType, this);
        mat = new matrixV(0.0, 0.0, 0.0);
    }
	//model position
	//will be the point closest to the origin 
    vector mPosition;
    //the scale
    double scale;
    //vertices
    vector[] vertices;
    //collision visibility type
    int cvType = COLLISION_INV;
    Color c;
    tri[] trimesh;
    collision coll;
    //the number that is assigned with the objs array
    int oNum;
    protected static matrixV mat;
    
    //change the cvType to whatever other type of collision visibility
    public void changeCV(int cvType) {
    		this.cvType = cvType;
    		coll.cvType = this.cvType;
    }
    
    //how does the object setup its vertices
    private void updatePos() {
        //x - blah goes left of the object's x-position
        //x + blah does the exact opposite of x - blah
        //y - blah goes down below the object's y-position
        //y + blah does the exact opposite of y - blah
        //z - blah goes backward more toward the player than the object's 
        //z - position
        //z + blah does the exact opposite of z - blah
    }
    
    public void changePos(double xpos, double ypos, double zpos) {
    		mPosition.mat.xarr = xpos;
    		mPosition.mat.yarr = ypos;
    		mPosition.mat.zarr = zpos;
    		this.updatePos();
    }
    
    public void changeColor(Color c) {
    		this.c = c;
    }
}