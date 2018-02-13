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
	if(row < 0 || col < 0 || row >= board.length || col >= board.length){
	    return false;
	}
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
	if(row < 0 || col < 0 || row >= board.length || col >= board.length){
	    return false;
	}
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
	return solveHelp(0);
    }

    public boolean solveHelp(int col){
	System.out.println(this);
	if(col == board.length){
	    return true;
	}

	for(int row = 0 ; row < board.length && col >= 0; row++){

	    //System.out.println("Add - Row, col, numQueens :" + row + ", " + col + ", " + numQueens);
	    //System.out.println(this);
	    
	    if(addQueen(row, col)){
		if(solveHelp(col + 1)){
		    //System.out.println("addQueen return true thing");
		    return true;
		}
		removeQueen(row, col);
	    }
	}
	return false;
    }
    
    public int countSolutions(){
	for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
	    for(int colIndex = 0; colIndex < board[rowIndex].length; colIndex++){
		if(board[rowIndex][colIndex] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return countHelp(0);
    }
    
    public int countHelp(int col){
	System.out.println(this);

	int numSolutions = 0;
	
	if(col == board.length){
	    return 1;
	}

	for(int row = 0 ; row < board.length && col >= 0; row++){

	    if(addQueen(row, col)){
		numSolutions = numSolutions + countHelp(col + 1);
		removeQueen(row, col);
	    }
	}
	
	return numSolutions;
    }
    
    public static void main(String[] args){
	QueenBoard center = new QueenBoard (11);
	
	QueenBoard a = new QueenBoard(5);

	System.out.println("-----addQueen-----");
	
	System.out.println(center);
	System.out.println(center.addQueen(5, 5));
	System.out.println(center);
	
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

	
	QueenBoard b = new QueenBoard(2);

	System.out.println(b.solve());
	System.out.println(b);

	QueenBoard c = new QueenBoard(10);

	System.out.println(c.solve());
	System.out.println(c);
	
	QueenBoard d = new QueenBoard(4);

	System.out.println(d.solve());
	System.out.println(d);

	QueenBoard e = new QueenBoard(3);

	System.out.println(e.solve());
	System.out.println(e);

	//QueenBoard f = new QueenBoard(6);

	//System.out.println(d.board[3][3] = 3);
	//System.out.println(d.solve());
	//System.out.println(d);

	QueenBoard g = new QueenBoard(6);

	System.out.println(g.solve());
	System.out.println(g);
	
	System.out.println("-----countSolutions-----");

	QueenBoard h = new QueenBoard(8);

	System.out.println(h.countSolutions());
	System.out.println(h);

	//love you Ivan Zhang
    }
}
