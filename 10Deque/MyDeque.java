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
	array = (Type[])new Object[initialCapacity];
	start = -1;
	end = -1;
	size = 0;
    }
    //fix
    public String toString(){ //need to update to conform to wrap arounds
	String returnString = "[";
	if(size() == 1){
	    returnString = returnString + array[start];
	}else{
	    for(int index = 0; index < size(); index++){
		returnString = returnString + array[index] + ", ";
	    }
	    returnString = returnString.substring(0, returnString.length() - 2);
	}
	
	return returnString + "]";
    }
    
    public int size(){
	return size;
    }

    public void addFirst(Type element){
	if(size() == 0){
	    start = 0;
	    end = 0;
	    array[0] = element;
	    size++;
	}else{
	    //need to implement wrap arounds and add befores
	}
    }

    public void addLast(Type element){
	if(size() == 0){
	    start = 0;
	    end = 0;
	    array[0] = element;
	    size++;
	}else{
	    array[end + 1] = element;
	    end++;
	    size++;
	}
    }

}
