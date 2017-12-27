package jgameengine;

//basic structure of every class in game engine
class structure {
    //standard and only type of collision is mesh collision
    //game constants(players, enemies, etc.) can go through the collision
    //but collision can still make an event occur or something like that
    //Invisible
    final int COLLISION_INV = 2;
    //game constants cannot go through the collision
    //Visible
    final int COLLISION_VIS = 3;
    public double calcMagnitude(double xarr, double yarr, double zarr) {
    	double magnitude = (xarr * xarr) + (yarr * yarr) + (zarr * zarr);
    	magnitude = Math.sqrt(magnitude);
    	return magnitude;
    }
}