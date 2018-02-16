public class KnightBoard{

    int[][] board;

    int[] movesRow = {2,  2, 1, -1, -2, -2,  1, -1};
    int[] movesCol = {1, -1, 2,  2,  1, -1, -2, -2};
    

    // Is zero included?
    public KnightBoard(int startingRows, int startingCols){
	if(startingRows <= 0 || startingCols <= 0){
	    throw new IllegalArgumentException();
	}
	board = new int[startingRows][startingCols];
    }

    /* NEED TO UPDATE THIS LATER AFTER NO MORE DEBUGGING
       Throw IllegalStateException
       Display 0's as underscores
       Blank board if never called solve or no solution
       Follow format on website */
    
    public String toString(){
	String returnString = "";
	for(int row = 0; row < board.length; row++){
	    for(int col = 0; col < board[row].length; col++){
		//if(board.length * board[row].length < 10){
		    returnString += board[row][col] + " ";
		    //}
		    //else{
		    //if(
		    //returnString += board[row][col] + " ";
		    //}
	    }
	    returnString += "\n";
	}
	return returnString;
    }

    public boolean solve(int startingRow, int startingCol){
	if(startingRow <= 0 || startingCol <= 0){
	    throw new IllegalStateException();
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
    
    /*
    //this was for testing if knight move nums are right
    private boolean solveH(int row, int col){
	board[row][col] = 5;
	for(int i = 0; i < movesRow.length; i++){
	    System.out.println(this);
	    board[row + movesRow[i]][col + movesCol[i]] = 9;
	}
	return true;
    }
    */

    private boolean solveH(int row, int col, int level){
	try{
	    System.out.println(level + "\n" + this);
	    if(board[row][col] == 0){
		board[row][col] = level;
		level++;
	    }
	    for(int loop = 0; loop < movesRow.length; loop++){
		if(solveH(row + movesRow[loop], col + movesCol[loop], level++)){
		    return true;
		}
		//board[row][col] = 0;
	    }
	    return true;
	}catch(Exception ArrayIndexOutOfBoundsException){
	    return false;
	}
    }
    
    public static void main(String[] args){

	KnightBoard a = new KnightBoard(7, 7);

	//System.out.println(a);
	//a.solve(3, 3);
	System.out.println(a);
	
	
    }
}
