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
    }
}
