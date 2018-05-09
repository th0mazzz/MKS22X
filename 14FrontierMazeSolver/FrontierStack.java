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

    public String toString(){
	Object[] array = stack.toArray();
	String s = "Head\n";
	for(int i = 0; i < array.length; i++){
	    s = s + array[i].toString() + "\n";
	}
	return s + "\nEnd";
    }

    public static void main(String[] args){
	FrontierStack a = new FrontierStack();
	a.add(new Location(6, 7, null));

	Location b = new Location(9, 10, null);
	Location c = new Location(4, 4, b);

	a.add(b);
	a.add(c);

	System.out.println(a);
	a.next();
	System.out.println(a);
	a.next();
	System.out.println(a);
    }
}
