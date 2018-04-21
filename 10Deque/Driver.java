public class Driver{

    public static void main(String[] args){

	/*
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
	a.addFirst("a");
	a.addFirst("a");
	a.addFirst("a");
	a.addFirst("a");
	System.out.println(a);
	a.addFirst("a");
	System.out.println(a.size());
	System.out.println(a);
	

	MyDeque<String> b = new MyDeque<>();
	System.out.println(b);
	b.addLast("First");
	b.addLast("Second");
	b.addLast("Third");
	b.addLast("Fourth");
	System.out.println(b);
	b.addFirst("Fifth");
	b.addFirst("Six");
	System.out.println(b);
	b.addLast("a");
	b.addLast("a");
	b.addLast("a");
	b.addLast("a");
	System.out.println(b);
	b.addLast("a");
	System.out.println(b);
	*/

	MyDeque<Integer> c = new MyDeque<>();

	for(int i = 10; i <= 100; i = i + 10){
	    
	    c.addFirst(new Integer (i));
	}
	System.out.println(c);
	
	for(int i = 10; i <= 40; i = i + 10){
	    
	    c.removeFirst();
	}

	c.addLast(new Integer (-20));
	c.addLast(new Integer (-30));

	
	c.removeFirst();
	c.removeFirst();
	c.removeFirst();
	c.removeFirst();
	c.removeFirst();
	c.removeFirst();
	c.removeFirst();
	c.addFirst(new Integer (1));
	c.removeFirst();

	
	
	

	System.out.println(c);
    }
    
}
