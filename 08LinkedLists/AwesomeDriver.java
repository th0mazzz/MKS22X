public class AwesomeDriver{

    public static void main(String[] args){

	MyLinkedListImproved<String> a = new MyLinkedListImproved<>();

	a.add("Hallejuhah");
	System.out.println(a);
	a.add("by");
	a.add("Beethoven?");
	System.out.println(a);

	MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
	for(int index = 0; index < 20; index++){
	    b.add((Integer)index);
	}

	System.out.println(b);

	for(Integer i : b){
	    System.out.print(i + " ");
	}
	
	System.out.println("==================================");
	System.out.println();

	MyLinkedListImproved<String> c = new MyLinkedListImproved<>();
	c.add("orange");
	c.add("apple");
	c.add("banana");
	c.add("aaple");
	c.add(2, "pineapple");
	System.out.println(c);
	System.out.println("maxIndex: " + c.max());
	System.out.println("minIndex: " + c.min());


	MyLinkedListImproved<String> d = new MyLinkedListImproved<>();
	d.add("bad");
	d.add("apples");
	d.add("smell");

	MyLinkedListImproved<String> e = new MyLinkedListImproved<>();
	e.add("yummy");
	e.add("and");
	e.add("good");
	d.extend(e);
	System.out.println(d);
	System.out.println("d's size: " + d.size());

	MyLinkedListImproved<String> f = new MyLinkedListImproved<>();
	f.extend(d);
	System.out.println(f);
	System.out.println("f's size: " + f.size());
	System.out.println("d is now: "); System.out.println(d);

	MyLinkedListImproved<String> g = new MyLinkedListImproved<>();
	MyLinkedListImproved<String> h = new MyLinkedListImproved<>();

	g.extend(h);
	System.out.println(g);
    }
}
