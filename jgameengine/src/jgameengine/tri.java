package jgameengine;
import java.awt.Color;

class tri extends structure {
	tri(vector[] vertices, object obj, int cvType) {
		this.cvType = cvType;
        this.vertices = vertices;
		this.coll = new collision(this.cvType, obj);
		this.chooseColor(Color.white);
		this.init = true;
    }
	
	//if failed to call constructor
	public void setup(vector[] vertices, object obj, int cvType) {
		if(!this.init)
		{
			this.cvType = cvType;
			this.vertices = vertices;
			this.coll = new collision(this.cvType, obj);
			this.chooseColor(Color.white);
		}
	}
	
    //vertices
    vector[] vertices = new vector[3];
    Color c;
    //if constructor is called
    boolean init;
    int cvType;
    //collision
    collision coll;
    
    //fill tri mesh
    public void chooseColor(Color c) {
        this.c = c;
    }
    
    public void changeCV(int cvType) {
    	this.cvType = cvType;
    	coll.cvType = this.cvType;
    }
}