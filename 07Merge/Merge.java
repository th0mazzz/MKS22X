public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];

	for(int i = 0; i < data.length; i++){ //copies data to temp
	    temp[i] = data[i];
	}
	
	msort(data, temp, 0, data.length - 1);
    }
    
    public static void msort(int[] data, int[] temp, int front, int back){
	//this is the insertion sort part
	if(back - front > 10){
	    for(int outIndex = front + 1; outIndex < back; outIndex++){
		for(int inIndex = front; inIndex < outIndex; inIndex++){
		    if(data[outIndex] < data[inIndex]){
			
			
		       
		    }
		}
	    }
	}
	
	if(front >= back){ //base case basically when front == back
	    return;
	}

      	int middle = (front / 2) + (back / 2); //finds mid

	msort(temp, data, front, middle); //first half
	msort(temp, data, middle + 1, back); //other half
	merge(data, temp, front, middle, middle + 1, back);
	
	
	/*
	System.out.println("data: " + toString(data));
	System.out.println("temp: " + toString(temp));
	*/
    }
    
    public static void merge(int[] data, int[] temp, int front, int middle, int middle2, int back){
	for(int index = front; index <= back; index++){

	    /*
	    System.out.println("front: " + front);
	    System.out.println("mid1: " + middle);
	    System.out.println("mid2: " + middle2);
	    System.out.println("back: " + back);

	    System.out.println();
	    */
	    
	    //System.out.println("dataFront: " + data[front] + ", dataMiddle2: " + data[middle2]);
	    
	    if(front <= middle){
		if(middle2 <= back){
		    if(temp[front] < temp[middle2]){
			data[index] = temp[front];
			front++;
		    }
		    else{
			data[index] = temp[middle2];
			middle2++;
		    }
		}
		else{
		    data[index] = temp[front];
		    front++;
		}
	    }
	    else{
		data[index] = temp[middle2];
		middle2++;
	    }


	    
	} //closes for loop
	
	
	    
    }


    public static String toString(int[] array){
	String returnString = "";
	for(int i = 0; i < array.length; i++){
	    returnString += array[i] + " ";
	}
	returnString += "\n";
	return returnString;
    }

    public static void main(String[] args){
       
	int[] test = {3, 0, 6, 2, 1, 4};
	System.out.println(toString(test));
	mergesort(test);
	System.out.println(toString(test));

	System.out.println("-----------------*************----------------");
       
	
	int[] test2 = {3, 1};
	System.out.println(toString(test2));
	mergesort(test2);
	System.out.println(toString(test2));

	System.out.println("-----------------*************----------------");

	int[] test3 = {3, 1, 4, 0};
	System.out.println(toString(test3));
	mergesort(test3);
	System.out.println(toString(test3));

	System.out.println("-----------------*************----------------");

	int[] test4 = {9,8,7,6,5,4,3,2,1,0};
	System.out.println(toString(test4));
	mergesort(test4);
	System.out.println(toString(test4));
	
	
    }
}
