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
	    addRemoveHelp(row, col, 0, 1, 1);
	    addRemoveHelp(row, col, 0, -1, 1);
	    addRemoveHelp(row, col, -1, 0, 1);
	    addRemoveHelp(row, col, 1, 0, 1);
	    addRemoveHelp(row, col, 1, 1, 1);
	    addRemoveHelp(row, col, 1, -1, 1);
	    addRemoveHelp(row, col, -1, 1, 1);
	    addRemoveHelp(row, col, -1, -1, 1);
	    return true;
	}else{
	    return false;
	}
    }

    public void addRemoveHelp(int row, int col, int rowInc, int colInc, int addOrRemove){
	for(int colIndex = col + colInc, rowIndex = row + rowInc;
		colIndex < board[row].length && rowIndex < board.length && colIndex >= 0 && rowIndex >= 0;
		colIndex = colIndex + colInc, rowIndex = rowIndex + rowInc){
		board[rowIndex][colIndex] = board[rowIndex][colIndex] + addOrRemove;
	    }
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] == -1){
	    board[row][col] = board[row][col] + 1;
	    addRemoveHelp(row, col, 0, 1, -1);
	    addRemoveHelp(row, col, 0, -1, -1);
	    addRemoveHelp(row, col, -1, 0, -1);
	    addRemoveHelp(row, col, 1, 0, -1);
	    addRemoveHelp(row, col, 1, 1, -1);
	    addRemoveHelp(row, col, 1, -1, -1);
	    addRemoveHelp(row, col, -1, 1, -1);
	    addRemoveHelp(row, col, -1, -1, -1);
	    return true;
	}else{
	    return false;
	}
    }







    









    
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);

	System.out.println("-----addQueen-----");
	
	System.out.println(a);

	System.out.println(a.addQueen(0,0));
	System.out.println(a);

	System.out.println(a.addQueen(0,0));
	System.out.println(a);

	System.out.println(a.addQueen(4,4));
	System.out.println(a);

	System.out.println(a.addQueen(3,4));
	System.out.println(a);

	System.out.println("-----removeQueen-----");

	System.out.println(a.removeQueen(3,4));
	System.out.println(a);

	System.out.println(a.removeQueen(0,2));
	System.out.println(a);

	System.out.println(a.removeQueen(0,4));
	System.out.println(a);

	System.out.println(a.removeQueen(0,0));
	System.out.println(a);
    }
}
