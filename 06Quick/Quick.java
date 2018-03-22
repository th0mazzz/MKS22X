public class Quick{

    public static void swap(int[] data, int index1, int index2){
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }

    /*
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
    */
    

    public static int[] partition(int[] data, int start, int end){

	int pivot = (int)(start + Math.random() * ((end - start)));	
	int pivotEle = data[pivot];

	
	
	swap(data, start, pivot); //puts pivot to front
	
	int low = start;
	int high = end;
	int current = start + 1;
	int lessThan = start;
	int greaterThan = end;

	while(current <= greaterThan){ //until current hits greaterThanCurrent section
	    
	    if(data[current] == pivotEle){ //just leave it be
		current++;
	    }
	    else{
		if(data[current] < pivotEle){ //move to greaterThan and greaterThan--
		    swap(data, current, lessThan);
		    current++;
		    lessThan++;
		}
		else{
       		    swap(data, current, greaterThan); //move to lessThan and lessThan--
		    greaterThan--;
		}
	    }
	    
	}

	int[] out = new int[2]; //returns values for when lessThan and greaterThans' indices
	out[0] = lessThan;
	out[1] = greaterThan;

	//System.out.print(toString(data));
	//System.out.println("     pivotIndex: " + pivot + " , pivotElement: " + pivotEle);
	return out; //returns mentioned indicies
	
    }
    
    public static int quickselect(int[] data, int k){
	
	int front = 0;
	int back = data.length - 1;

	int[] inputRange = partition(data, front, back); //uses the indicies from partition

	while(k > inputRange[1] || k < inputRange[0]){ //while we are NOT at kth element
	    
	    if(inputRange[0] > k){ //move closer to k
		back = inputRange[0] - 1;
	    }
	    if(inputRange[1] < k){ //move closer to k
		front = inputRange[1] + 1;
	    }

	    inputRange = partition(data, front, back); //select a new range based on updates
	}

	//System.out.println(data[inputRange[0]]);
	return data[inputRange[0]]; //the kth smallest element
	    
	/*
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
	*/
    }

    public static void quicksort(int[] data){
	quicksortHelp(data, 0, data.length - 1);
	
    }

    public static void quicksortHelp(int[] data, int front, int back){
	int[] range = partition(data, front, back);

	if(front != back){
	    //System.out.println("front: " + front + ", " + back);
	    quicksortHelp(data, front + 1, back);
	    quicksortHelp(data, front, back - 1);

	}
	
    
	
	
	/*
	//fun while you lasted easy code
	int[] ordered = new int[data.length];
	
	for(int i = 0; i < ordered.length; i++){
	    ordered[i] = quickselect(data, i);
	}
	
	data = ordered;
	*/
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
	    System.out.println("partition returns: " + toString(partition(array, 0, 7)));
	    System.out.println(toString(array));
	}
	*/
	
	int[] ary = {1,1,1,1,4,6,6,5,6,4,3,6,67,4,67,8,7,6,54,65,7,78,7,44,23,57,7,8,55,23,5,767,8,67,67,643,56,77,7,46,568,6346};
	//int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	//int[] ary = {0,0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,2};
	
	//System.out.println(toString(ary));

	/*
	quickselect( ary , 0 ); //would return 0
	quickselect( ary , 1 );  //would return 2
	quickselect( ary , 2 );  //would return 5
	quickselect( ary , 3 );  //would return 10
	quickselect( ary , 4 );  //would return 15
	quickselect( ary , 5 );  //would return 23
	*/

	//System.out.println(toString(partition(ary)));

	quicksort(ary);
	
	System.out.println(toString(ary));
    }
    
}
