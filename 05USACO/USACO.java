import java.util.*;
import java.io.*;

public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{
	File storageFile = new File(filename); //makes scanner for file
	Scanner in = new Scanner(storageFile);

	int row = Integer.parseInt(in.next()); //initializes variables
	int col = Integer.parseInt(in.next());
	int elevation = Integer.parseInt(in.next());
	int num = Integer.parseInt(in.next()); //USELESS PARAMETER

	int[][] lake = new int[row][col];

	for(int rowIndex = 0; rowIndex < row; rowIndex++){
	    for(int colIndex = 0; colIndex < col; colIndex++){
		lake[rowIndex][colIndex] = Integer.parseInt(in.next());
	    }
	}

	//DEBUGGING PURPOSES
	System.out.println("Original");
	for(int rowIndex = 0; rowIndex < row; rowIndex++){
	    for(int colIndex = 0; colIndex < col; colIndex++){
		System.out.print(lake[rowIndex][colIndex] + "  ");
	    }
	    System.out.println();
	}
	System.out.println();
	//DEBUGGING PURPOSES

	while(in.hasNext()){ //loop until no more instructions
	    int xcor = Integer.parseInt(in.next()) - 1; //initialize data to be used
	    int ycor = Integer.parseInt(in.next()) - 1;
	    int dig = Integer.parseInt(in.next());

	    //DEBUGGING
	    System.out.println("xcor: " + xcor + ", ycor: " + ycor);
	    System.out.println("dig: " + dig);
	    
	    int counter = 3; //locate the greatest number in the 3x3 grid specified
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

	    int newNum = greatestNum - dig; //calculate the new value (high - dig amount)

	    counter = 3; //replace numbers larger than newNum with newNum in 3x3 grid
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

	    //DEBUGGING PURPOSES
	for(int rowIndex = 0; rowIndex < row; rowIndex++){
	    for(int colIndex = 0; colIndex < col; colIndex++){
		System.out.print(lake[rowIndex][colIndex] + "  ");
	    }
	    System.out.println();
	}
	System.out.println();
	//DEBUGGING PURPOSES
	    
	}
	                     //once instructions all done
	int aggDepthSum = 0; //add up all values subtracted from elevation
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

	
	//DEBUGGING PURPOSES
	for(int rowIndex = 0; rowIndex < row; rowIndex++){
	    for(int colIndex = 0; colIndex < col; colIndex++){
		System.out.print(lake[rowIndex][colIndex] + "  ");
	    }
	    System.out.println();
	}
	//DEBUGGING PURPOSES
	
	return aggDepthSum * 72 * 72; //multiply by inches (6ft = 72in)
    }

    public static int silver (String filename) throws FileNotFoundException{
	File storageFile = new File(filename); //create scanner and search for file
	    Scanner in = new Scanner(storageFile);

	    int row = Integer.parseInt(in.next()); //initialize variables
	    int col = Integer.parseInt(in.next());
	    int time = Integer.parseInt(in.next());

	    char[][] field = new char[row][col];
	    int[][] currentBoard = new int[row][col];
	    int[][] pastBoard = new int[row][col];
	    
       	    String data = ""; //gather up the characters into a string
	    int counter = 0;
	    while(in.hasNext() && counter < row){
		data = data + in.next();
		counter++;
	    }

	    int stringCounter = 0; //place characters into 2D array 'field'
	    for(int rowIndex = 0; rowIndex < row; rowIndex++){
		for(int colIndex = 0; colIndex < col; colIndex++){
		    field[rowIndex][colIndex] = data.charAt(stringCounter);
		    stringCounter++;
		}
	    }

	    int row1 = Integer.parseInt(in.next()) - 1; //initialize variables after field
	    int col1 = Integer.parseInt(in.next()) - 1;
	    int row2 = Integer.parseInt(in.next()) - 1;
	    int col2 = Integer.parseInt(in.next()) - 1;

	    pastBoard[row1][col1] = 1;

	    int[] rowMove = {0,  0, 1, -1}; //to make code more concise
	    int[] colMove = {1, -1, 0,  0};        
	    
	    for(int timeElapsed = 0; timeElapsed < time; timeElapsed++){ //loop through arrays 'time' times

      		currentBoard = new int[row][col];
		
		for(int rowIndex = 0; rowIndex < row; rowIndex++){ //loops through each iteration of array
		    for(int colIndex = 0; colIndex < col; colIndex++){

			int neighborSum = 0;
			
			for(int look = 0; look < 4; look++){ //adds sums of neighboring cells
			    try{
				neighborSum = neighborSum + pastBoard[rowIndex + rowMove[look]][colIndex + colMove[look]];
			    }catch(ArrayIndexOutOfBoundsException e){
				//Do nothing
			    }
			}

			if(field[rowIndex][colIndex] != '*'){ //makes cell 'neighborSum' if not tree
			    currentBoard[rowIndex][colIndex] = neighborSum;
			}
		    }
		}

		pastBoard = currentBoard; //store in a past array 

		/*//debug loop
		System.out.println("past");
		for(int rowI = 0; rowI < row; rowI++){
		    for(int colI = 0; colI < col; colI++){
			System.out.print(pastBoard[rowI][colI] + " ");
		    }
		    System.out.println();
		}
		System.out.println();
		//debug loop */
	    }

	return currentBoard[row2][col2];
    }
    
    public static void main(String[] args){
	try{
	    System.out.println(bronze("inputBronze.dat"));
	    //System.out.println(silver("inputSilver.dat"));
	}catch(FileNotFoundException e){
	    System.out.println("File not found");
	}
    }
}

