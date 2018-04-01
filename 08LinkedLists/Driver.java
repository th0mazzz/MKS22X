public class Driver{

    public static void main(String[] args){
	
	MyLinkedList test = new MyLinkedList();
	
	System.out.println(test);

	test.add(0);
	test.add(1);
	test.add(20);

	System.out.println(test);

	test.clear();

	System.out.println(test);

	test.add(0, 2);
	test.add(1, 4);
	test.add(0, 0);

	System.out.println(test);

	test.remove(2);
	
	System.out.println(test);

	test.add(2);
	test.add(4);
	test.add(16);
	test.add(2);

	System.out.println(test);

	Integer two = 2;
	test.remove(two);
	test.remove(two);

	System.out.println(test);

	Integer seven = 7;
	test.remove(seven);

	System.out.println(test);

	System.out.println(test.get(0));
	System.out.println(test.get(1));
	System.out.println(test.get(2));
	System.out.println(test.get(3));

	test.set(0, -1);
	test.set(3, 25);

	System.out.println(test);

	System.out.println("Size: " + test.size());

	System.out.println(test.indexOf(2));
	System.out.println(test.indexOf(16));
    }
}
