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
	if(board[row][col] == 0){
	    board[row][col] = board[row][col] - 1;
	    for(int colIndex = 0; colIndex < board[row].length; colIndex++){
		if(colIndex != col){
		    board[row][colIndex] = board[row][colIndex] + 1;
		}
	    }
	    //need to make vertical and diagonal threatened spaces
	    return true;
	}else{
	    return false;
	}
    }

	//privtae boolean removeQueen(int row, int col){
	//}





    









    
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	
	System.out.println(a);

	a.addQueen(2,2);

	System.out.println(a);
    }
}
