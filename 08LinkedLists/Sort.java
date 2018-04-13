public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	
	Integer max = findMaxDigits(data);
	int maxDigits = log10(max);
	System.out.println(maxDigits);

	MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	
	
    }

    public static Integer findMaxDigits(MyLinkedListImproved<Integer> data){
	int maxIndex = data.max();
	Integer maxValue = data.get(maxIndex);
	return maxValue;
    }

    public static int log10(Integer num){
	int tens = 0;
	while(num >= 10){
	    tens++;
	    num = num / 10;
	}
	return tens + 1;
    }

    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	a.add(new Integer (23));
	a.add(new Integer (44));
	a.add(new Integer (12));
	a.add(new Integer (98));
	a.add(new Integer (987654321));
	radixsort(a);

    }
}    
