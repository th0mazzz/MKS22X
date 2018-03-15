public class Quick{

    public static int partition(int[] data, int start, int end){
	int pivot = (int)(start + Math.random() * ((end - start) + 1));
	int pivotEle = data[pivot];

	int temp = data[0];
	data[0] = pivotEle;
	data[pivot] = temp;

	int front = 1;
	int back = data.length - 1;
	for(; front <= back;){

	    if(data[front] > pivotEle){
		int temper = data[front];
		data[front] = data[back];
		data[back] = temper;
		back--;
	    }else{
		front++;
	    }
	    
	}

	int temporary = data[0];
	data[0] = data[back];
	data[back] = temporary;

	return back;
    }
    
    public static int quickselect(int []data, int k){

	
	

	return -1; //should return k'th smallest value
    }


    

    public static void main(String[] args){

	//Test for partition
	int[] cool = {0, 5, 2, 7, 4, 3, 8, 1, 9, 6};

	for(int index = 0; index < cool.length; index++){
	    System.out.print(cool[index] + " ");
	}
	
	System.out.println("returned: " + partition(cool, 0, 9));
	
	for(int index = 0; index < cool.length; index++){
	    System.out.print(cool[index] + " ");
	}

	
	int[]ary = { 2, 10, 15, 23, 0,  5};  //sorted :  {0,2,5,10,15,23}
	quickselect( ary , 0 );// would return 0
	quickselect( ary , 1 );//  would return 2
	quickselect( ary , 2 );//  would return 5
	quickselect( ary , 3 );//  would return 10
	quickselect( ary , 4 );//  would return 15
	quickselect( ary , 5 );//  would return 23
	
    }
}
