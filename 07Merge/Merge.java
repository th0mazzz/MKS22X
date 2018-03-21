public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];

	for(int i = 0; i < data.length; i++){ //copies data to temp
	    temp[i] = data[i];
	}
	
	msort(data, temp, 0, data.length - 1);
    }
    
    public static void msort(int[] data, int[] temp, int front, int back){

	if(front >= back){ //base case basically when front == back
	    return;
	}

      	int middle = (front / 2) + (back / 2); //finds mid
	
	msort(temp, data, front, middle); //first half
	msort(temp, data, middle + 1, back); //other half
	merge(data, temp, front, middle, middle + 1, back);
	
    }
    
    public static void merge(int[] data, int[] temp, int front, int middle, int middle2, int back){
	for(int index = front; index <= back; index++){
	    
	    System.out.println("front: " + front);
	    System.out.println("mid1: " + middle);
	    System.out.println("mid2: " + middle2);
	    System.out.println("back: " + back);

	    System.out.println();

	    
	    System.out.println("dataFront: " + data[front] + ", dataMiddle2: " + data[middle2]);
	    
	    if(data[front] < data[middle2]){
		if(front <= middle){
		    temp[index] = data[front];
		    front++;
		}else{
		    
		}
	    }
	    else{
		if(middle2 <= back){
		    temp[index] = data[middle2];
		    middle2++;
		}else{

		}
	    }


	    
	} //closes for
	
	
	    
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
	/*
	int[] test = {3, 0, 6, 2, 1, 4};
	System.out.println(toString(test));
	mergesort(test);
	System.out.println(toString(test));

	System.out.println("-----------------*************----------------");
	*/
	int[] test2 = {3, 1};
	System.out.println(toString(test2));
	mergesort(test2);
	System.out.println(toString(test2));

	System.out.println("-----------------*************----------------");

	int[] test3 = {3, 1, 4, 0};
	System.out.println(toString(test3));
	mergesort(test3);
	System.out.println(toString(test3));
	
	
    }
}
