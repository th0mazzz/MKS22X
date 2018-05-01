import java.util.*;
public class RunningMedian{

    private int size;
    private MyHeap<Double> min, max; 
    
    public RunningMedian(){
	min = new MyHeap<>();
	max = new MyHeap<>(false);
	size = 0;
    }

    public void add(Double element){
	if(size == 0){
	    max.add(element);
	}else{
	    if(element >= getMedian()){
		max.add(element);
	    }else{
		min.add(element);
	    }
	}
    }

    public Double getMedian(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
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

    public int size(){
	return size;
    }

    public String toString(){
	return "min:" + "\n" + min.toString() + "\n" + "max" + "\n" + max.toString();
    }

    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	System.out.println(a);
	a.add(2.3);
	System.out.println(a);
    }
}
