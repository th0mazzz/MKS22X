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
    
}
