public class KnightBoard{

    int[][] board = { { 1,  0, 19, 14,  3},
		  {18, 13,  2,  9, 20},
		  {23,  8,  0,  4, 15},
		  {12, 17,  6, 21, 10},
		  { 7, 22, 11, 16,  5} };;

    int[] movesRow = {2,  2, 1, -1, -2, -2,  1, -1};
    int[] movesCol = {1, -1, 2,  2,  1, -1, -2, -2};

    String[] debug = {"2 Down 1 Right", "2 Down 1 Left", "2 Right 1 Down", "2 Right 1 Up",
		      "2 Up 1 Right", "2 Up 1 Left", "2 Left 1 Down", "2 Left 1 Up"};
    

    public KnightBoard(int startingRows, int startingCols){
	if(startingRows <= 0 || startingCols <= 0){
	    //throw new IllegalArgumentException();
	}
	//board = new int[startingRows][startingCols];	
    }
    
    public String toString(){
	String returnString = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board.length * board[row].length < 10){
		    if(board[row][col] == 0){
			returnString += " _ ";
		    }
		    else{
			returnString += " " + board[row][col] + " ";
		    }
		}
		else{
		    if(board[row][col] < 10){
			if(board[row][col] == 0){
			    returnString += " _ ";
			}
			else{
			    returnString += " " + board[row][col] + " ";
			}
		    }
		    else{
			returnString += board[row][col] + " ";
		    }
		}
	    }
	    returnString += "\n";
	}
	return returnString;
    }

    public boolean solve(int startingRow, int startingCol){
	if(startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[startingRow].length){
	    throw new IllegalArgumentException();
	}
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(startingRow, startingCol, 1);
    }

    public boolean solveH(int row, int col, int level){
	/*
	  System.out.println(Text.go(1,1));
	  System.out.println("\n" + this);
	  System.out.println("Level: " + level);
	  Text.wait(0); //adjust this delay
	*/

	if(row < 0 || row >= board.length || col < 0 || col >= board[row].length){
	    return false;
	}

	if(board[row][col] == 0){
	    board[row][col] = level;
	    level++;
	}
	else{
	    return false;
	}

	for(int loop = 0; loop < movesRow.length; loop++){
	    //System.out.println("Looking at: (" + movesRow[loop] + ", " + movesCol[loop] + ")");
	    if(solveH(row + movesRow[loop], col + movesCol[loop], level)){
		return true;
	    }
	}

	if(level - 1 == board.length * board[row].length){
	    return true;
	}

	board[row][col] = 0;
	return false;
    }

    public int countSolutions(int startingRow, int startingCol){
	if(startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[startingRow].length){
	    throw new IllegalStateException();
	}
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		if(board[row][col] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return countH(startingRow, startingCol, 1);
    }

    public int countH(int row, int col, int level){
	
	//System.out.println(Text.go(1,1));
	//System.out.println("\n" + this);
	//System.out.println("Level: " + level);
	//Text.wait(0); //adjust this delay
	
	int numSolutions = 0;
	
	if(row < 0 || row >= board.length || col < 0 || col >= board[row].length){
	    return 0;
	}

	
	if(level  - 1== board.length * board[row].length){
	    return 1;
	}

	if(board[row][col] == 0){
	    board[row][col] = level;
	    level++;
	}else{
	    return 0;
	}
	
	for(int loop = 0; loop < movesRow.length; loop++){
	    //System.out.println("In loop: " + loop);
	    numSolutions += countH(row + movesRow[loop], col + movesCol[loop], level);
	    System.out.println(numSolutions);
	}

	board[row][col] = 0;

	
	return numSolutions;
    }
    
    
    public static void main(String[] args){
	System.out.print("\033[H\033[2J");  //resets cursor to default location
	System.out.flush();  //clears the terminal

	KnightBoard a = new KnightBoard(5, 5);

	System.out.println(a);
	//System.out.println(a.solve(2,4));
	System.out.println(a.countSolutions(0, 0));
	System.out.println(a);

	/*
	KnightBoard b = new KnightBoard(5, 5);
	System.out.println(b.countSolutions(3,3));

	KnightBoard c = new KnightBoard(7,7);
	System.out.println(c.solve(3,3));

	KnightBoard d = new KnightBoard(7,7);
	System.out.println(d.countSolutions(3,3));
	*/
	
    }
}

