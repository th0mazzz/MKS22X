public class KnightBoard{

    int[][] board;

    int[] movesRow = {2,  2, 1, -1, -2  -2,  1, -1};
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
		returnString += board[row][col] + " ";
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

	return solveH(startingRow, startingCol);
    }
    
    private boolean solveH(int row, int col){
	return true;
    }




    public static void main(String[] args){

	KnightBoard a = new KnightBoard(5, 5);

	System.out.println(a);
	
	
    }
}
