public class Driver{

    public static void main(String[] args){
	
	MyDeque<String> a = new MyDeque<>();
	System.out.println(a);
	a.addFirst("Apple");
	System.out.println(a);
	a.addFirst("I come first");
	System.out.println(a);
	a.addFirst("a");
	a.addFirst("a");
	a.addFirst("a");
	a.addFirst("a");
	System.out.println(a);

    }
    
}
