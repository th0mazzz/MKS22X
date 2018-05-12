public class Location implements Comparable<Location>{

    private int x, y;
    private Location previous;
    private double distance;

    public Location (int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public Location (int _x, int _y, Location prev, double dist){
	x = _x;
	y = _y;
	previous = prev;
	distance = dist;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public Location getPrev(){return previous;}
    public double getDist(){return distance;}

    public String toString(){
	return "(" + getX() + ", " + getY() + "dist: " + getDist() +")";
    }

    public int compareTo(Location other){
	if(distance < other.distance){
	    return -1;
	}else{
	    return 1;
	}
    }
    
    public static void main(String[] args){
	Location a = new Location(3, 2, null);
	System.out.println(a);
    }
}
