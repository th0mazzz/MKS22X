public class MyDeque<Type>{

    private int size;
    private Type[] array;

    @SuppressWarning("unchecked")
    public MyDeque(){
	array = (Type[])new Object[10];
	size = 0;
    }
    
    @SuppressWarning("unchecked") 
    public MyDeque(int initialCapacity){
	array = (Type[])new Object[initialCapacity];
	size = 0;
    }

    public int size(){
	return size;
    }

    public void addFirst(String element){
	
    }

}
