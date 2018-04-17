import java.util.Random;
public class Sort{

    public static void radixsort(MyLinkedListImproved<Integer> data){
	
	Integer max = findMaxDigits(data);
	int maxDigits = log10(max);

	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	
	for(int i = 0; i < 10; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	}

	MyLinkedListImproved<Integer> dataPos = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> dataNeg = new MyLinkedListImproved<>();
	MyLinkedListImproved<Integer> workspace = new MyLinkedListImproved<>();

	for(Integer i : data){
	    if(i >= 0)
		dataPos.add(i);
	    else
		dataNeg.add(i);
	}

	//System.out.println(dataPos);
	//System.out.println(dataNeg);
	
	for(int runthru = 0; runthru <= maxDigits; runthru++){ //Positives and 0
	    for(Integer i : dataPos){
		int value = digInPos(i, runthru);
		buckets[value].add(i);
	    }

	    dataPos.clear();
	    
	    for(int index = 0; index < 10; index++){
		dataPos.extend(buckets[index]);
	    }
	}

	//System.out.println("\n" + dataPos);
	
	for(int runthru = 0; runthru <= maxDigits; runthru++){ //Negatives
	    for(Integer i : dataNeg){
		int value = digInPos(i * -1, runthru);
		buckets[9 - value].add(i);
	    }

	    dataNeg.clear();
	    
	    for(int index = 0; index < 10; index++){
		dataNeg.extend(buckets[index]);
	    }
	}

	//System.out.println(dataNeg);

	data.clear();
	data.extend(dataNeg);
	data.extend(dataPos);

    }
    
    public static void radixsortSlowerVersion(MyLinkedListImproved<Integer> data){ //THIS WAS THE OLD ONE

	Integer max = findMaxDigits(data);
	int maxDigits = log10(max);
	//System.out.println("MaxDigits: " + maxDigits);


	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] bucketsNeg = new MyLinkedListImproved[10];
	
	for(int i = 0; i < 10; i++){
	    buckets[i] = new MyLinkedListImproved<Integer>();
	    bucketsNeg[i] = new MyLinkedListImproved<Integer>();
	}
	
	for(Integer i : data){
	    if(i >= 0)
		buckets[0].add(i);
	    else
		bucketsNeg[0].add(i);
	}	

	for(int runthru = 0; runthru <= maxDigits; runthru++){ //Positive and 0
	    
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

	
	for(int runthru = 0; runthru <= maxDigits; runthru++){ //Negative
	    
	    @SuppressWarnings("unchecked")
		MyLinkedListImproved<Integer>[] workspace = new MyLinkedListImproved[10];

	    for(int i = 0; i < 10; i++){
		workspace[i] = new MyLinkedListImproved<Integer>();
	    }
	    for(int index = 0; index < 10; index++){
		for(Integer i : bucketsNeg[index]){
		
		    int value = digInPos(i * -1, runthru);
		
		    workspace[9 - value].add(i);
		}
	    }
	    
	    bucketsNeg = workspace;
	    
	}

	/*
	for(int i = 0; i < 10; i++){
	    System.out.print(bucketsNeg[i]);
	}
	
	
	System.out.println();
	for(int i = 0; i < 10; i++){
	    System.out.print(buckets[i]);
	}
	System.out.println();
	System.out.println();
	*/

	data.clear();

	/*
	System.out.println("data: " + data + " , " + data.size());
	
	for(int i = 0; i < 10; i++){
	    System.out.println(buckets[i] + " , size: " + buckets[i].size() );
	}
	*/
	
	for(int i = 0; i < 10; i++){
	    data.extend(bucketsNeg[i]);
	}
	for(int i = 0; i < 10; i++){
	    data.extend(buckets[i]);
	}
    }

    public static Integer findMaxDigits(MyLinkedListImproved<Integer> data){
	int maxIndex = data.max();
	int minIndex = data.min();
	Integer maxValue = data.get(maxIndex);
	Integer minValue = data.get(minIndex);
	if(Math.abs(maxValue) >= Math.abs(minValue))
	    return maxValue;
	else
	    return minValue;
    }

    public static int log10(Integer num){
	int tens = 0;
	num = Math.abs(num);
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

	Random generator = new Random();
	
	for(int index = 0; index < 1000; index++){

	    a.add(new Integer (generator.nextInt(100) * -1));
	    a.add(new Integer (generator.nextInt(100) * -1));
	    
	}
	
	System.out.println("Input: " + a + "\n");
	radixsort(a);
	System.out.println("\n\nOutput: " + a);

    }
}    
