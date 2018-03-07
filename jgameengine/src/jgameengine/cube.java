package jgameengine;

//update
//demo object
class cube extends object {
    cube(double xpos, double ypos, double zpos) {
        super(xpos, ypos, zpos, 1.0, 8);
    }
    
    public void updatePos() {
    		mat.change(this.scale, 0.0, 0.0);
    		vertices[1].mat = addMat(vertices[0].mat, mat);
    		mat.change(0.0, this.scale, 0.0);
    		vertices[2].mat = addMat(vertices[0].mat, mat);
    		mat.change(0.0, 0.0, this.scale);
    		vertices[3].mat = addMat(vertices[0].mat, mat);
    		mat.change(this.scale, 0.0, this.scale);
    		vertices[4].mat = addMat(vertices[0].mat, mat);
    		mat.change(this.scale, this.scale, 0.0);
    		vertices[5].mat = addMat(vertices[0].mat, mat);
    		mat.change(0.0, this.scale, this.scale);
    		vertices[6].mat = addMat(vertices[0].mat, mat);
    		mat.change(this.scale, this.scale, this.scale);
    		vertices[7].mat = addMat(vertices[0].mat, mat);
    		for(int i = 0; i < vertices.length; i++) {
    			vertices[i].mat.magnitude = calcMagnitude(vertices[i].mat);
    		}
        //coll.update();
    }
}