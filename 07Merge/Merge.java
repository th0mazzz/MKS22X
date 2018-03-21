public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	
    }
    
    public static void msort(int[] data, int[] temp, int front, int back){
	int middle = (front / 2) + (back / 2);

	while(front <= back){
	    msort(data, temp, front, middle);
	    msort(data, temp, middle + 1, back);
	}
	//i think sorting code goes here
    }
    
    public static void merge(int somestuffhere){
	
	
	
    }


    
}
