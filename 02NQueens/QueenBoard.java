public class QueenBoard{
    
    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
    }

    public String toString(){
	String returnString = "";
	for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
	    for(int colIndex = 0; colIndex < board[rowIndex].length; colIndex++){
		if(board[rowIndex][colIndex] == -1){
		    returnString = returnString + "Q ";
		}
		else{
		    returnString = returnString + board[rowIndex][colIndex] + " ";
		}
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

    public void addRemoveHelp(int row, int col, int rowInc, int colInc, int addOrRemove){
	for(int colIndex = col + colInc, rowIndex = row + rowInc;
		colIndex < board[row].length && rowIndex < board.length && colIndex >= 0 && rowIndex >= 0;
		colIndex = colIndex + colInc, rowIndex = rowIndex + rowInc){
		board[rowIndex][colIndex] = board[rowIndex][colIndex] + addOrRemove;
	    }
    }

    public boolean solve(){
	for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
	    for(int colIndex = 0; colIndex < board[rowIndex].length; colIndex++){
		if(board[rowIndex][colIndex] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelp(0, 0, board.length, 0);
    }

    public boolean solveHelp(int row, int col, int n, int numQueens){
	System.out.println("Row, col, numQueens :" + row + ", " + col + ", " + numQueens);
	System.out.println(this);

	for(; col < board[row].length; col++){
	    int rowIndex = row;
	    int colIndex = col;
	    for(; rowIndex < board.length; rowIndex++){
		if(addQueen(rowIndex, colIndex)){
		    numQueens++;
		    while(rowIndex < board.length){
			return solveHelp(0, 0, n, numQueens);
			
		    }
		}
	    }
	}




	
	if(numQueens == n){
	    return true;
	}
	return false;
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

	System.out.println("-----solve-----");

	System.out.println(a.solve());
	System.out.println(a);

	//a.board[2][2] = 2;
	//System.out.println(a);

	//System.out.println(a.solve());
	//System.out.println(a);

	
    }
}
