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
    }
}
