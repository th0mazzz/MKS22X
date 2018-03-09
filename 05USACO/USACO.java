import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{
	File storageFile = new File(filename);
	Scanner in = new Scanner(storageFile);
	
	
	return -1;
    }

    public static int silver (String filename) throws FileNotFoundException{
	    File storageFile = new File(filename);
	    Scanner in = new Scanner(storageFile);
	    
	    int row = Integer.parseInt(in.next());
	    int col = Integer.parseInt(in.next());
	    int time = Integer.parseInt(in.next());

	    char[][] field = new char[row][col];

	    String data = "";
	    int counter = 0;
	    while(in.hasNext() && counter < row){
		data = data + in.next();
		counter++;
	    }

	    int stringCounter = 0;
	    for(int rowIndex = 0; rowIndex < row; rowIndex++){
		for(int colIndex = 0; colIndex < col; colIndex++){
		    field[rowIndex][colIndex] = data.charAt(stringCounter);
		    stringCounter++;
		}
	    }

	    int row1 = Integer.parseInt(in.next());
	    int col1 = Integer.parseInt(in.next());
	    int row2 = Integer.parseInt(in.next());
	    int col2 = Integer.parseInt(in.next());
	    
	    
	    for(int rowIndex = 0; rowIndex < row; rowIndex++){
		for(int colIndex = 0; colIndex < col; colIndex++){
		    System.out.print(field[rowIndex][colIndex]);
		}
		System.out.println();
	    }
	    
	return -1;
    }
    
    public static void main(String[] args){
	try{
	    silver("inputSilver.dat");
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }
}

