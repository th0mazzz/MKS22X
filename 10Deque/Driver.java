public class Driver{

    public static void main(String[] args){
	
	MyDeque<String> a = new MyDeque<>();
	System.out.println(a);
	a.addFirst("Apple");
	System.out.println(a);
	a.addLast("I come after");
	System.out.println(a);

    }
    
}
