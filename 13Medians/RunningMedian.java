public class RunningMedian{

    private int size;
    private MyHeap<Double> min, max; 
    
    public RunningMedian(){
	min = new MyHeap<>();
	max = new MyHeap<>(false);
	size = 0;
    }

    public void add(Double element){

    }

    public Double getMedian(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
    }

    public int size(){
	return size;
    }
}
