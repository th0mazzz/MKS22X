public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	
	
	
	
	
    }

    public static void findMaxDigits(MyLinkedListImproved<Integer> data){
	int maxIndex = data.max();
	Integer maxValue = data.get(maxIndex);
	System.out.println(maxValue);
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	a.add(new Integer (23));
	a.add(new Integer (44));
	a.add(new Integer (12));
	findMaxDigits(a);
    }
}    
