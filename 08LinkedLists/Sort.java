public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> data){
	
	Integer max = findMaxDigits(data);
	int maxDigits = log10(max);
	System.out.println("MaxDigits: " + maxDigits);


	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];

	for(int i = 0; i < 10; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	}
	
	for(Integer i : data){
	    buckets[0].add(i);
	}	

	for(int runthru = 0; runthru <= maxDigits; runthru++){
	    
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] workspace = new MyLinkedListImproved[10];

	    for(int i = 0; i < 10; i++){
		workspace[i] = new MyLinkedListImproved<Integer>();
	    }
	    for(int index = 0; index < 10; index++){
		for(Integer i : buckets[index]){
		
		    int value = digInPos(i, runthru);
		
		    workspace[value].add(i);
		}
	    }

	    buckets = workspace;
	    
	}

	System.out.println();
	for(int i = 0; i < 10; i++){
	    System.out.print(buckets[i]);
	}
	System.out.println();
	System.out.println();

	data.clear();

	System.out.println("data: " + data + " , " + data.size());
	
	for(int i = 0; i < 10; i++){
	    System.out.println(buckets[i] + " , size: " + buckets[i].size() );
	}
	
	for(int i = 0; i < 10; i++){ //issue here
	    System.out.println("extend " + i);
	    data.extend(buckets[i]);
	}
	
	System.out.println();
	System.out.println(data);
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

    public static int digInPos(Integer num, int position){
	int current = 1;
	while(current < position){
	    num = num / 10;
	    current++;
	}
	return num % 10;
    }
    
    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	
	/*
	a.add(new Integer (23));
	a.add(new Integer (9));
	a.add(new Integer (44));
	a.add(new Integer (12));
	a.add(new Integer (132));
	a.add(new Integer (98));
	//a.add(new Integer (987654321));

	*/

	for(int index = 0; index < 10; index++){
	    
	    a.add(new Integer ((int)(Math.random()*10) * (int)(Math.random() * 10)));
	}
	System.out.println(a);
	radixsort(a);
	System.out.println(a);

    }
}    
