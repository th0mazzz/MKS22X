import java.util.*;
public class Sorts{
    
    public static void heapsort(Integer[] array){
	MyHeap<Integer> heap = heapify(array);
	int counter = size(array) - 1;
	while(heap.size() > 0){
	    array[counter] = heap.remove();
	    counter--;
	    System.out.println(print(array));
	    //System.out.println("..." + heap);
	}
    }
    
    public static MyHeap<Integer> heapify(Integer[] array){
	MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < size(array); i++){
	    heap.add(array[i]);
	}
	//System.out.println(heap);
	return heap;
    }

    public static void swap(int index1, int index2, Integer[] array){
	Integer storage = array[index1];
	array[index1] = array[index2];
	array[index2] = storage;
    }
    
    public static int size(Integer[] array){
	int size = 0;
	for(int i = 0; i < array.length; i++){
	    if(array[i] != null){
		size++;
	    }
	}
	return size;
    }

    public static String print(Integer[] array){
	String returnString = "[";
	for(int i = 0; i < array.length; i++){
	    returnString = returnString + array[i]  +", ";
	}
	returnString = returnString.substring(0, returnString.length() - 2);
	return returnString + "]";
    }
    
    public static void main(String[] args){
	Integer[] a = new Integer[10];
	
	for(int i = 0; i < 10; i++){
	    a[i] = new Integer ((int)(Math.random() * 10));
	}

	System.out.println("....." + print(a));
	heapsort(a);
	System.out.println("....." + print(a));
	
    }
    
}
