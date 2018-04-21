import java.util.*;
public class MyDeque<Type>{

    private int start, end;
    private int size;
    private Type[] array;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	array = (Type[])new Object[10];
	start = -1;
	end = -1;
	size = 0;
    }
    
    @SuppressWarnings("unchecked") 
    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	array = (Type[])new Object[initialCapacity];
	start = -1;
	end = -1;
	size = 0;
    }

    public String toString(){ //need to update to conform to wrap arounds
	String returnString = "[";
	System.out.println("start: " + start +  " , end: " + end);
	
	if(size() == 0){
	    return "[]";
	}
	if(size() == 1){
	    returnString = returnString + array[start];
	}else{
	    for(int index = 0; index < array.length; index++){
		returnString = returnString + array[index] + ", ";
	    }
	    returnString = returnString.substring(0, returnString.length() - 2);
	}
	
	return returnString + "]";
	
    }
    
    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	
	Type[] extended = (Type[]) new Object[array.length * 2];
	if(start <= end){
	    int addIndex = extended.length - 1;
	    for(int index = end; index >= 0; index--){
		extended[addIndex] = array[index];
		addIndex--;
	    }
	}else{ //start > end
	    int index = 0;
	    for(; index <= end; index++){
		extended[index] = array[index];
	    }
	    end = index - 1;
	    int addBack = extended.length - 1;
	    for(int indexLoop = array.length - 1; indexLoop >= start; indexLoop--){
		//System.out.println("..." + array[indexLoop]);
		extended[addBack] = array[indexLoop];
		addBack--;
	    }
	    start = addBack + 1;
	}
	array = extended;
    }
    
    public void addFirst(Type element){ //exception
	if(size() == 0){
	    start = 0;
	    end = 0;
	    array[start] = element;
	    size++;
	}else{
	    if(size() == array.length){
		resize();
	    }
	    if(start - 1 < 0){
		start = array.length - 1;
		array[start] = element;
		size++;
	    }else{
		start--;
		array[start] = element;
		size++;
	    }
	}
    }

    public void addLast(Type element){ //exception
	if(size() == 0){
	    start = 0;
	    end = 0;
	    array[end] = element;
	    size++;
	}else{
	    if(size() == array.length){
		resize();
	    }
	    if(end >= array.length){
		end = 0;
		array[end] = element;
		size++;
	    }else{
		end++;
		array[end] = element;
		size++;
	    }
	}
    }

    public Type removeFirst(){
	if(size() == 0){
	    throw new NoSuchElementException();
	}
	Type returnValue = array[start];
	array[start] = null;

	start++;
	if(start >= array.length){
	    start = 0;
	}
	size--;
	return returnValue;
    }

}
