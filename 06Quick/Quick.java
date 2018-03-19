public class Quick{

    public static void swap(int[] data, int index1, int index2){
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }

    
    public static int partition(int[] data, int start, int end){

	int pivot = (int)(start + Math.random() * ((end - start)));	
	int pivotEle = data[pivot];
	
	swap(data, start, pivot);

	int front = start + 1;
	int back = end;

	while(front <= back){
      	    if(pivotEle < data[front]){
		swap(data, front, back);
		back--;
	    }
	    else{
		front++;
	    }
	}

	swap(data, start, back);

	return back;

    }
    

    //public static WRITE WITH DUTCH 

    public static int quickselect(int[] data, int k){
	
	int front = 0;
	int back = data.length - 1;
	int current = partition(data, front, back);
	
	while(current != k){
	    
	    if(current > k){
		back = current - 1;
	    }
	    else{
		front = current + 1;
	    }

	    current = partition(data, front, back);
	}

	return data[current];
	
    }

    public static void quicksort(int[] data){
	int[] ordered = new int[data.length];
	
	for(int i = 0; i < ordered.length; i++){
	    ordered[i] = quickselect(data, i);
	}
	
	data = ordered;
	
    }
    
    public static String toString(int[] data){
	String returnString = "";
	for(int i = 0; i < data.length; i++){
	    returnString = returnString + " " + data[i];
	}
	return returnString;
    }

    public static void main(String[] args){

	/*
	int[] array = {999, 1, 4, 2, 998, 3, 997, 0};

	for(int i = 0; i < 1; i++){
	    System.out.println(toString(array));
	    System.out.println("partition returns: " + partition (array, 0, 7));
	    System.out.println(toString(array));
	}
	*/
	
	
	
	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}

	System.out.println(toString(ary));
	
	/*quickselect( ary , 0 ); //would return 0
	quickselect( ary , 1 );  //would return 2
	quickselect( ary , 2 );  //would return 5
	quickselect( ary , 3 );  //would return 10
	quickselect( ary , 4 );  //would return 15
	quickselect( ary , 5 );  //would return 23
	*/

	quicksort(ary);

	System.out.println(toString(ary));
    }
    
}
