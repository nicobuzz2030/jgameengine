package jgameengine;

class cube extends object {
    cube(double xpos, double ypos, double zpos) {
        this.mPosition.mat.xarr = xpos;
        this.mPosition.mat.yarr = ypos;
        this.mPosition.mat.zarr = zpos;
        this.scale = 2.5f;
        this.updatePos();
        //vertices                                //second element will always be three
        this.vertices = new vector[8];
        //collision:
        //triangle mesh
        //I made formula for meshes
        //you can do whatever you want
        for(int i = 0; i < trimesh.length; i++) {
        	trimesh[i].setup(vertices, this, this.cvType);
        }
    }
    
    //amount of sides
    int sides = 6;
    tri[] trimesh = new tri[(this.sides * 2)];
    
    public void changeCV(int cvType) {
    	super.changeCV(cvType);
    	for(int i = 0; i < trimesh.length; i++) {
    		trimesh[i].changeCV(this.cvType);
    	}
    }
    
    @Override
    public double[] updatePos() {
        double[] ret = new double[3];
        for(int i = 0; i < trimesh.length; i++) 
        	trimesh[i].coll.update();
        this.mPosition.mat.magnitude = calcMagnitude(this.mPosition.mat.xarr, this.mPosition.mat.yarr, this.mPosition.mat.zarr);
        return ret;
    }
}