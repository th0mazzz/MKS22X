import java.util.*;
import java.io.*;
public class Maze{


    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.

    */

    public Maze(String filename) throws FileNotFoundException{
	
	setUpMaze(filename);
	animate = false;
	
    }
    
    private void setUpMaze(String filename) throws FileNotFoundException{
	File storageFile = new File(filename);
	Scanner in = new Scanner(storageFile);

	String mazeString = "";

	//this section of code finds row length and makes maze into string form
	int rowLength = 0;
	while(in.hasNext()){
	    String word =  in.nextLine();
	    mazeString = mazeString + word + "\n";
	    rowLength++;
	}

	//this section of code finds column length
	int colLength = 0;
	while(mazeString.charAt(colLength) != '\n'){
	    colLength++;
	}
	
	maze = new char[rowLength][colLength];

	int index = 0;
	int numS = 0;
	int numE = 0;

	System.out.println("MazeLength" + mazeString.length());
	while(index < mazeString.length()){
	    if(mazeString.charAt(index) == '\n'){
		mazeString = mazeString.substring(0, index) + mazeString.substring(index + 1);
	    }
	    if(mazeString.charAt(index) == 'E'){
		numE++;
	    }

	    if(mazeString.charAt(index) == 'S'){
		numS++;
	    }

	    System.out.println(index);
	    index++;
	}

	
	
	System.out.println("numS: " + numS + ", numE: " + numE);
	
	int anotherIndex = 0;
	for(int rowIndex = 0; rowIndex < colLength; rowIndex++){
	    for(int colIndex = 0; colIndex < rowLength; colIndex++){
		
		maze[rowIndex][colIndex] = mazeString.charAt(anotherIndex);
		anotherIndex++;
		
	    }
	}

	/*
	System.out.println(mazeString);
	for(int rowIndex = 0; rowIndex < rowLength; rowIndex++){
	    for(int colIndex = 0; colIndex < colLength; colIndex++){
		
		System.out.print(maze[rowIndex][colIndex]);
		
	    }
	    System.out.println();
	}
	*/
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

            //find the location of the S. 


            //erase the S


            //and start solving at the location of the s.

            //return solve(???,???);

	return -1;//so it compiles
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }


}


