public class MyDeque{

    private int size;
    private String[] array;
    
    public MyDeque(){
	array = new String[10];
	size = 0;
    }

    public MyDeque(int initialCapacity){
	array = new String[initialCapacity];
	size = 0;
    }

    public int size(){
	return size;
    }

    public void addFirst(String element){
	
    }

}
