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

	if(front < back){
	    //insertion sort
	    if(back - front < 10){
		for(int index = front; index <= back; index++){
		    int currentEle = data[index];

		    while(index - 1 >= 0 && currentEle < data[index - 1]){
			data[index] = data[index - 1];
			index--;
		    }

		    data[index] = currentEle;
	    
		}
	    }else{
		int[] range = partition(data, front, back);
		quicksortHelp(data, front, range[0] - 1);
		quicksortHelp(data, range[1] + 1, back);
	    }
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
	
       
    }
    
}
