import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{
	File storageFile = new File(filename);
	Scanner in = new Scanner(storageFile);

	int row = Integer.parseInt(in.next());
	int col = Integer.parseInt(in.next());
	int elevation = Integer.parseInt(in.next());
	int num = Integer.parseInt(in.next()); //USELESS PARAMETER

	int[][] lake = new int[row][col];

	for(int rowIndex = 0; rowIndex < row; rowIndex++){
	    for(int colIndex = 0; colIndex < col; colIndex++){
		lake[rowIndex][colIndex] = Integer.parseInt(in.next());
	    }
	}

	while(in.hasNext()){
	    int xcor = Integer.parseInt(in.next());
	    int ycor = Integer.parseInt(in.next());
	    int dig = Integer.parseInt(in.next());
	    
	    int counter = 3;
	    int greatestNum = -1;
	    for(int rowIndex = xcor; rowIndex >= 0 && rowIndex < row && counter > 0; rowIndex++){
		int innerCounter = 3;
		for(int colIndex = ycor; colIndex >= 0 && colIndex < col && innerCounter > 0; colIndex++){
		    if(lake[rowIndex][colIndex] > greatestNum){
			greatestNum = lake[rowIndex][colIndex];
			innerCounter--;
		    }
		    innerCounter--;
		}
		counter--;
	    }

	    int newNum = greatestNum - dig;

	    counter = 3;
	    for(int rowIndex = xcor; rowIndex >= 0 && rowIndex < row && counter > 0; rowIndex++){
		int innerCounter = 3;
		for(int colIndex = ycor; colIndex >= 0 && colIndex < col && innerCounter > 0; colIndex++){
		    if(lake[rowIndex][colIndex] > newNum){
			lake[rowIndex][colIndex] = newNum;
		    }
		    innerCounter--;
		}
		counter--;
	    }    
	}

	int aggDepthSum = 0;
	for(int rowIndex = 0; rowIndex < row; rowIndex++){
	    for(int colIndex = 0; colIndex < col; colIndex++){
		if(elevation - lake[rowIndex][colIndex] < 0){
		    lake[rowIndex][colIndex] = 0;
		}else{
		    lake[rowIndex][colIndex] = elevation - lake[rowIndex][colIndex];
		    aggDepthSum = aggDepthSum + lake[rowIndex][colIndex];
		}
	    }
	}

	
	/* DEBUGGING PURPOSES
	for(int rowIndex = 0; rowIndex < row; rowIndex++){
	    for(int colIndex = 0; colIndex < col; colIndex++){
		System.out.print(lake[rowIndex][colIndex] + " ");
	    }
	    System.out.println();
	}	
	*/
	return aggDepthSum * 72 * 72;
    }

    public static int silver (String filename) throws FileNotFoundException{
	    File storageFile = new File(filename);
	    Scanner in = new Scanner(storageFile);
	    
	    int row = Integer.parseInt(in.next());
	    int col = Integer.parseInt(in.next());
	    int time = Integer.parseInt(in.next());

	    char[][] field = new char[row][col];
	    int[][] currentBoard = new int[row][col];
	    int[][] pastBoard = new int[row][col];

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

	    pastBoard[row1][col1] = 1;

	    int[] rowMove = {0,  0, 1, -1};
	    int[] colMove = {1, -1, 0,  0};

	    //...........................................................................................        me being bored            
	    
	    for(int timeElapsed = 0; timeElapsed < time; timeElapsed++){

      		currentBoard = new int[row][col];
		
		for(int rowIndex = 0; rowIndex < row; rowIndex++){
		    for(int colIndex = 0; colIndex < col; colIndex++){
			
			

			int neighborSum = 0;
			
			for(int look = 0; look < 4; look++){
			    try{
				neighborSum = neighborSum + pastBoard[rowIndex + rowMove[look]][colIndex + colMove[look]];
			    }catch(ArrayIndexOutOfBoundsException e){
				//Do nothing
			    }
			}

			if(field[rowIndex][colIndex] != '*'){
			    currentBoard[rowIndex][colIndex] = neighborSum;
			}
		    }
		}

		pastBoard = currentBoard;

		//debug loop
		System.out.println("past");
		for(int rowI = 0; rowI < row; rowI++){
		    for(int colI = 0; colI < col; colI++){
			System.out.print(pastBoard[rowI][colI] + " ");
		    }
		    System.out.println();
		}
		System.out.println();
		//debug loop
	    }
	    
	    
	    
	return currentBoard[row2][col2];
    }
    
    public static void main(String[] args){
	try{
	    System.out.println(bronze("inputBronze2.dat"));
	    System.out.println(silver("inputSilver.dat"));
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }
}

