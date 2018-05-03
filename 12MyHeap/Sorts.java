import java.util.*;
public class Sorts{
    
    public static void heapsort(Integer[] array){
	heapify(array);
    }
    
    public static void heapify(Integer[] array){
	for(int i = size(array) - 1; i >= 0; i--){
	    int parent = (i - 1) / 2;
	    if(array[parent] < array[i]){
		swap(parent, i, array);
	    }
	    
	}
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
	Integer[] a = {new Integer (2), new Integer (100), new Integer (49), new Integer (22)};
	heapify(a);
	System.out.println(print(a));
	
    }
    
}
