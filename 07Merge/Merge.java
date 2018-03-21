public class Merge{

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }
    
    public static void msort(int[] data, int[] temp, int front, int back){

	if(front >= back){
	    return;
	}
	
	for(int i = front; i < back + 1; i++){
	    temp[i] = data[i];
	}

	int middle = (front / 2) + (back / 2);
	
	msort(temp, data, front, middle);
	msort(temp, data, middle + 1, back);
	merge(data, temp, front, back);
	
	//i think sorting code goes here
    }
    
    public static void merge(int[] data, int[] temp, int front, int back){
	for(int i = front; i < back + 1; i++){
	    data[i] = temp[i];
	}
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
    }
}
