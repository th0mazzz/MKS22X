import java.util.*;
public class FrontierQueue implements Frontier{

    ArrayDeque<Location> queue;

    public FrontierQueue(){
	queue = new ArrayDeque<>();
    }

    public void add(Location n){
	queue.add(n);
    }

    public Location next(){
	return queue.remove();
    }

    public boolean hasNext(){
	return queue.peek() != null;
    }

    public String toString(){
	Object[] array = queue.toArray();
	String s = "Head\n";
	for(int i = 0; i < array.length; i++){
	    s = s + array[i].toString() + "\n";
	}
	return s + "\nEnd";
    }

    public static void main(String[] args){
	FrontierQueue a = new FrontierQueue();
	a.add(new Location(1, 2, null));
	a.add(new Location(4, 5, null));

	Location b = new Location(55, 2, null);
	Location c = new Location(2, 12, b);
	Location d = new Location(3, 44, c);

	a.add(b);
	a.add(c);
	a.add(d);
	
	System.out.println(a);
	a.next();
	System.out.println(a);
	a.next();
	System.out.println(a);
    }
}
