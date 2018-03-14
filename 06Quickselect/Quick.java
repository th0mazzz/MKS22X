public class Quick{

    public int partition(int[] data, int start, int end){
	int pivot = (int)(start + Math.random() * ((end - start) + 1));
	int pivotEle = data[pivot];

	int temp = data[0];
	data[0] = pivotEle;
	data[pivot] = temp;
	
	for(int front = 1, back = data.length - 1; front <= back;){

	    System.out.println("front: " + data[front]);
	    System.out.println("back: " + data[back]);
	    System.out.println("pivot: " + pivotEle);
	    
	    if(data[front] > pivotEle){
		int temper = data[front];
		data[front] = data[back];
		data[back] = temper;
		back--;
		//System.out.println("Swapped index " + front + " and " + back);
	    }else{
		front++;
	    }

	    
	    for(int index = 0; index < data.length; index++){
		System.out.print(data[index] + " ");
	    }
	    
	    //NEED TO WORK ON
	}

	
	for(int index = 0; index < data.length; index++){
	    
	    System.out.println("comparing: " + data[0] + " and " + data[index]);
	    
	    if(pivotEle < data[index]){
		int temper = data[0];
		data[0] = data[index - 1];
		data[index - 1] = temper;
		return index - 1;
	    }
	}

	int temper = data[0];
	data[0] = data[data.length - 1];
	data[data.length - 1] = temper;
	
	return data.length - 1;
    }
    
    public static int quickselect(int []data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
    }


    

    public static void main(String[] args){

	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	quickselect( ary , 0 );// would return 0
	quickselect( ary , 1 );//  would return 2
	quickselect( ary , 2 );//  would return 5
	quickselect( ary , 3 );//  would return 10
	quickselect( ary , 4 );//  would return 15
	quickselect( ary , 5 );//  would return 23
	
    }
}
