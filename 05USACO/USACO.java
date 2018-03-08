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

	    //System.out.println(row + ", " + col + ", " + time);

	    int counter = 0;
	    int area = row * col;
	    for(int rowIndex = 0; rowIndex < row && counter < area; rowIndex++){
		for(int colIndex = 0; colIndex < col && counter < area; colIndex++){
		    field[row][col] = in.charAt(counter);//this charAt no good
		}
		in.next();
	    }

	    for(int rowIndex = 0; rowIndex < row; rowIndex++){
		for(int colIndex = 0; colIndex < col; colIndex++){
		    System.out.print(field[rowIndex][colIndex]);
		}
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

