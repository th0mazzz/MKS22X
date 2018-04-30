public class MyHeap{

    public String[] array;
    public int size;
    public boolean isMax;
    
    public MyHeap(){
	array = new String[17];
	size = 0;
	isMax = true;
    }

    public MyHeap(boolean isMax){
	array = new String[17];
	size = 0;
	this.isMax = isMax;
    }

    public void resize(){
	String[] larger = new String[(array.length - 1) * 2 + 1];
	for(int i = 0; i < array.length; i++){
	    larger[i] = array[i];
	}
	array = larger;
    }

    public void add(String s){
	
    }

    public String remove(){
	return "placeholder";
    }
    
    public String peek(){
	return "placeholder";
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
	MyHeap a = new MyHeap();
	System.out.println(a);
	a.resize();
	System.out.println(a);
    }
}
