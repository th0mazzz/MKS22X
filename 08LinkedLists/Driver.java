public class Driver{

    public static void main(String[] args){
	
	MyLinkedList test = new MyLinkedList();
	
	System.out.println(test);
	
	test.add(100);
	test.add(200);
	test.add(300);
	test.add(400);
	test.add(500);
	test.add(1343284);

	System.out.println(test);
	System.out.println(test.size());
	System.out.println(test.get(2));
	test.set(5, 600);

	System.out.println(test);

	test.add(2, 250);
	System.out.println(test.size());
	System.out.println(test);
	test.add(3, 275);
	System.out.println(test);

	System.out.println(test.indexOf(5));
	System.out.println(test.indexOf(500));

	Integer sixHunna = 600;
	test.remove(sixHunna);
	System.out.println(test);
	
    }
}
