package jgameengine;

//update
class tri extends structure {
	tri(vector[] vertices, object obj) {
        this.vertices = vertices;
		this.init = true;
    }
	
	//if failed to call constructor
	public void setup(vector[] vertices, object obj) {
		if(!this.init)
		{
			this.vertices = vertices;
		}
	}
	
    vector[] vertices = new vector[3];
    //if constructor is called
    boolean init;
}