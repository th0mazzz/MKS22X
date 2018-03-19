public class Quick{

    public static void swap(int[] data, int index1, int index2){
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }

    
    public static int partition(int[] data, int start, int end){

	int pivot = (int)(start + Math.random() * ((end - start)));	
	int pivotEle = data[pivot];
	//System.out.println("pivot index: " + pivot);
	//System.out.println("pivot element: " + pivotEle);

	//System.out.println(toString(data) + "\n");
	
	swap(data, start, pivot);

	int front = start+1;
	int back = end;

	while(front <= back){
	    //System.out.println("["+front+", "+back+"]");
	    //System.out.println(toString(data));

	    // System.out.println("front: " + front + ", back: " + back + "\n");
	    //System.out.println(toString(data));
	    
	    if(pivotEle < data[front]){
		//System.out.println(pivotEle + " is smaller than " + data[front]);
		swap(data, front, back);
		back--;
	    }
	    else{
		//System.out.println(pivotEle + " is larger than or equal to " + data[front]);
		front++;
	    }
	}

	swap(data, start, back);

	
	//System.out.println(toString(data));
	//System.out.println(back);

	//System.out.println("-------------------------------------------");
	return back;
	
    }
    

    //public static WRITE WITH DUTCH 

    public static int quickselect(int[] data, int k){
	
	int front = 0;
	int back = data.length - 1;
	//System.out.println("Partiton called");
	int current = partition(data, front, back);
	//System.out.println("Partiton ended");
	//SOMETHING IS STILL WRONG
	//IT STILL DISPLAYS SEEMINGLY RANDOM ANSWERS >:(
	
	while(current != k){
	    //System.out.println("k: " + k);

	    //System.out.println(toString(data));
	    
	    if(current > k){
		back = current - 1;
	    }
	    else{
		front = current + 1;
	    }

	    //System.out.println("Partiton called");
	    current = partition(data, front, back);
	    //System.out.println("Partiton ended");
	}

	System.out.println("quickselect: " + data[current]);
	return data[current];
	
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
	//System.out.println(toString(array));
	
	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	//quickselect( ary , 0 ); //would return 0
	
	quickselect( ary , 1 );  //would return 2
	quickselect( ary , 2 );  //would return 5
	quickselect( ary , 3 );  //would return 10
	quickselect( ary , 4 );  //would return 15
	quickselect( ary , 5 );  //would return 23
	
    }
    
}
