public class Driver{

    public static void main(String[] args){
	
	MyLinkedList test = new MyLinkedList();
	
	System.out.println(test);

	test.add(0, 100);
	
	System.out.println(test);

	test.add(0, 200);
	
	System.out.println(test);
	//System.out.println(test);

	System.out.println(test.getNode(1));
    }
}
