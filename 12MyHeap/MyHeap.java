import java.util.*;
public class MyHeap{

    public String[] array;
    public int size;
    public boolean isMax;
    
    public MyHeap(){
	array = new String[10];
	size = 0;
	isMax = true;
    }

    public MyHeap(boolean isMax){
	array = new String[10];
	size = 0;
	this.isMax = isMax;
    }

    public void resize(){
	String[] larger = new String[array.length * 2];
	for(int i = 0; i < array.length; i++){
	    larger[i] = array[i];
	}
	array = larger;
    }

    public void add(String s){
	if(size() == array.length){
	    resize();
	}
	array[size()] = s;
	int current = size();
	int parent = (size() - 1) / 2;
	if(isMax){
	    while(array[current].compareTo(array[parent]) > 0){
		String temp = array[current];
		array[current] = array[parent];
		array[parent] = temp;
		current = parent;
		parent = (parent - 1) / 2;
	    }
	}else{
	    while(array[current].compareTo(array[parent]) < 0){
		String temp = array[current];
		array[current] = array[parent];
		array[parent] = temp;
		current = parent;
		parent = (parent - 1) / 2;
	    }
	}
	size++;
    }

    public String remove(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
	String oldRoot = array[0];
	array[0] = array[size() - 1];
	array[size() - 1] = null;
	size--;
	int current = 0;
	int left = current * 2 + 1;
	int right = current * 2 + 2;
	if(isMax){
	    while(left < size() && array[current].compareTo(array[left]) < 0 &&
	    array[current].compareTo(array[right]) < 0){
		if(array[left].compareTo(array[right]) > 0){
		    String temp = array[left];
		    array[left] = array[current];
		    array[current] = temp;
		    current = left;
		    left = current * 2 + 1;
		    right = current * 2 + 2;
		}else{
		    String temp = array[right];
		    array[right] = array[current];
		    array[current] = temp;
		    current = right;
		    left = current * 2 + 1;
		    right = current * 2 + 2;
		}
	    }
	}else{
	    while(left < size() && array[current].compareTo(array[left]) > 0 &&
		  array[current].compareTo(array[right]) > 0){
		if(array[left].compareTo(array[right]) < 0){
		    String temp = array[left];
		    array[left] = array[current];
		    array[current] = temp;
		    current = left;
		    left = current * 2 + 1;
		    right = current * 2 + 2;
		}else{
		    String temp = array[right];
		    array[right] = array[current];
		    array[current] = temp;
		    current = right;
		    left = current * 2 + 1;
		    right = current * 2 + 2;
		}
	    }
	}
	return oldRoot;
    }
    
    public String peek(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
	return array[0];
    }

    public int size(){
	return size;
    }

    public String toString(){
	String returnString = "[";
	for(int index = 0; index < array.length; index++){
	    returnString = returnString +  array[index] + ", ";
	}
	returnString = returnString.substring(0, returnString.length() - 2);
	return returnString + "]";
    }

    public static void main(String[] args){
	MyHeap a = new MyHeap(false);
	System.out.println(a);
	//a.resize();
	a.add("b");
	a.add("b");
	a.add("c");
	a.add("d");
	a.add("e");
	a.add("f");
	a.add("g");
	a.add("h");
	a.add("n");
	a.add("a");
	System.out.println(a);
	System.out.println(a.remove());
	System.out.println(a);
    }
}
