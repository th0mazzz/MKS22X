public class KnightBoard{

    int[][] board;

    // Is zero included?
    public KnightBoard(int startingRows, int startingCols){
	if(startingRows < 0 || startingCols < 0){
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

    //Move the knight I suppose
    private boolean solveH(int row, int col){

    }




    public static void main(String[] args){

	KnightBoard a = new KnightBoard(5, 5);

	System.out.println(a);

	
    }
}
