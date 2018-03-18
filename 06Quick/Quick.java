public class Quick{

    public static void swap(int[] data, int index1, int index2){
	int temp = data[index1];
	data[index1] = data[index2];
	data[index2] = temp;
    }
    
    public static int partition(int[] data, int start, int end){

	int pivot = (int)(start + Math.random() * ((end - start) + 1));	
	int pivotEle = data[pivot];
	
	swap(data, start, pivot);

	int front = start;
	int back = end;

	while(front <= back){
	    //System.out.println("["+front+", "+back+"]");
	    //System.out.println(toString(data));
	    if(data[front] > pivotEle){
		swap(data, front, back);
		back--;
	    }
	    else{
		front++;
	    }
	}

	swap(data, 0, back);

	
	//System.out.println(toString(data));
	
	return back;
	
    }

    public static int quickselect(int[] data, int k){
	
	int front = 0;
	int back = data.length - 1;
	int current = partition(data, front, back);

	//SOMETHING IS STILL WRONG
	//IT STILL DISPLAYS SEEMINGLY RANDOM ANSWERS >:(
	
	while(current != k){

	    System.out.println(toString(data));
	    
	    if(current > k){
		back = current - 1;
	    }
	    else{
		front = current + 1;
	    }

	    current = partition(data, front, back);
	}

	System.out.println(data[current]);
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

	int[] array = {999, 1, 4, 2, 998, 3, 997, 0};

	//System.out.println(toString(array));
	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	quickselect( ary , 0 ); //would return 0
	quickselect( ary , 1 );  //would return 2
	quickselect( ary , 2 );  //would return 5
	quickselect( ary , 3 );  //would return 10
	quickselect( ary , 4 );  //would return 15
	quickselect( ary , 5 );  //would return 23
	    
    }
    
}
