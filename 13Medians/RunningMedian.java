import java.util.*;
public class RunningMedian{

    private int size;
    private MyHeap<Double> min, max; 
    
    public RunningMedian(){
	min = new MyHeap<>(false); //all values greater than or equal to med
 	max = new MyHeap<>(); //all values smaller than med
	size = 0;
    }

    public void add(Double element){
	if(size() == 0){
	    max.add(element);
	}else{
	    if(element >= getMedian()){
		min.add(element);
	    }else{
		max.add(element);
	    }
	}

	if(max.size() - min.size() == 2){
	    min.add(max.remove());
	}
	if(min.size() - max.size() == 2){
	    max.add(min.remove());
	}
	
	size++;
    }

    public Double getMedian(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
	if(min.size() == 0 || max.size() == 0){
	    if(min.size() == 0){
		return max.peek();
	    }else{
		return min.peek();
	    }
	}else{
	    if(Math.abs(min.size() - max.size()) == 1){
		if(min.size() > max.size()){
		    return min.peek();
		}else{
		    return max.peek();
		}
	    }else{
		return (max.peek() + min.peek()) / 2.0;
	    }
	}
    }

    public int size(){
	return size;
    }

    public String toString(){
	return "min:" + "\n" + min.toString() + "\n" + "max" + "\n" + max.toString();
    }

    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	//System.out.println(a);
	a.add(10.0);
	a.add(30.0);
	a.add(40.0);
	a.add(90.0);
	//a.add(80.0);
	System.out.println("med: " + a.getMedian());
	System.out.println(a);
    }
}
