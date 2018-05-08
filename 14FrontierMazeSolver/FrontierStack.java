import java.util.*;
public class FrontierStack implements Frontier{

    ArrayDeque<Location> stack;

    public FrontierStack(){
	stack = new ArrayDeque<>();
    }

    public void add(Location n){
	stack.add(n);
    }

    public Location next(){
	return stack.removeLast();
    }

    public boolean hasNext(){
	return stack.peekLast() != null;
    }
    
}
