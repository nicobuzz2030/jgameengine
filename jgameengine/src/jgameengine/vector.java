package jgameengine;

//update
class vector {
    vector(double xpos, double ypos, double zpos) {
        this.mat = new matrixV(xpos, ypos, zpos);
    }
    
    matrixV mat;
}
