public class FrontierPriorityQueue implements Frontier{
    
    MyHeap<Location> priority;
    
    public FrontierPriorityQueue(){
	priority = new MyHeap<>(false);
    }

    public Location next(){
	return priority.remove();
    }

    public void add(Location n){
	priority.add(n);
    }

    public boolean hasNext(){
	return priority.peek() != null;
    }

    public String toString(){
	return priority.toString();
    }
}
