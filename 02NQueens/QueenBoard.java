public class QueenBoard{
    
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public String toString(){
	String returnString = "";
	for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
	    for(int colIndex = 0; colIndex < board[rowIndex].length; colIndex++){
		returnString = returnString + board[rowIndex][colIndex] + " ";
	    }
	    returnString = returnString + "\n";
	}
	return returnString;
    }

    private boolean addQueen(int row, int col){
	board[row][col] - 1;
    }











    
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(3);
	
	System.out.println(a);
    }
}
