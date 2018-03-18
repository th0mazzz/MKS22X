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

    public static String toString(int[] data){
	String returnString = "";
	for(int i = 0; i < data.length; i++){
	    returnString = returnString + " " + data[i];
	}
	return returnString;
    }

    public static void main(String[] args){

	int[] array = {999, 1, 4, 2, 998, 3, 997, 0};

	System.out.println(toString(array));
	partition(array, 0, 7);
	
	
    }

}
