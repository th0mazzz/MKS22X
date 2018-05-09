public class Location{

    private int x, y;
    private Location previous;

    public Location (int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public Location getPrev(){return previous;}

    public String toString(){
	return "(" + getX() + ", " + getY() + ", [" + getPrev() +"])";
    }

    public static void main(String[] args){
	Location a = new Location(3, 2, null);
	System.out.println(a);
    }
}
