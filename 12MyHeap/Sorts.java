import java.util.*;
public class Sorts{
    
    public static void heapsort(Integer[] array){
	MyHeap<Integer> heap = heapify(array);
	System.out.println(heap);
    }
    
    public static MyHeap<Integer> heapify(Integer[] array){
	MyHeap<Integer> heap = new MyHeap<>();
	heap.setArray(array);
	return heap;
    }
    
    public static void main(String[] args){

	Integer[] a = {new Integer (2), new Integer (31), new Integer (49)};
	heapsort(a);
    }
    
}
