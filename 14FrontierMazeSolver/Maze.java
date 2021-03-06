import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class Maze{
    
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    Location start,end;
    private char[][]maze;
    private boolean isAStar;

    /*

      obtain x and y of location L
      obtain coors of neighbors
      determine if neighbors are valid neighbors 
      make neighbors into location objects
      put location objects into array
      return array

     */
    public Location[] getNeighbors(Location L){
	
	int xcor = L.getX(); //obtain xcor and ycor
	int ycor = L.getY();

	int[][] neighCoors = { {xcor, ycor + 1}, {xcor, ycor - 1}, {xcor - 1, ycor}, {xcor + 1, ycor} }; //make int[][] of location coors

	Location[] preneighbors = new Location[4];
	int index = 0;
	
	for(int i = 0; i < 4; i++){ //make viable neighbors into locations and put into preneighbors array
	    int[] oneNeigh = neighCoors[i];
	    if(oneNeigh[0] >= 0 && oneNeigh[0] < maze.length && oneNeigh[1] >= 0 && oneNeigh[1] < maze[0].length){
		if(get(oneNeigh[0], oneNeigh[1]) == ' ' || get(oneNeigh[0], oneNeigh[1]) == 'E'){
		    if(!isAStar){
			preneighbors[index] = new Location(oneNeigh[0], oneNeigh[1], L, calcDist(oneNeigh[0], oneNeigh[1]));		    
			index++;
		    }else{
			preneighbors[index] = new Location(oneNeigh[0], oneNeigh[1], L, calcDist(oneNeigh[0], oneNeigh[1]), L.getDistSoFar() + 1);		    
			index++;
		    }
		}
	    }
	}

	Location[] neighbors = new Location[index]; //make array the size of preneighbors
	int counter = 0;

	for(int i = 0; i < index; i++){ //to make sure end array has no nulls
	    if(preneighbors[i] != null){
		neighbors[counter] = preneighbors[i];
		counter++;
	    }
	}
	
	return neighbors;
	
    }
    
    public Location getStart(){
	return start;
    }
    public Location getEnd(){
	return end;
    }

    public int calcDist(int x, int y){
	return Math.abs(getEnd().getX() - x) + Math.abs(getEnd().getY() - y);
    }

    public void setAStar(boolean value){
	isAStar = value;
    }

    private static String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private static String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN+"\033[1;1H");
    }
    public Maze(String filename){
	isAStar = false;
	
	ArrayList<char[]> lines = new ArrayList<char[]>();
	int startr=-1, startc=-1;
	int endr=-1,endc=-1;
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		lines.add(in.nextLine().toCharArray());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: "+filename);
	    System.exit(1);
	}
	maze = new char[lines.size()][];
	for(int i = 0; i < maze.length; i++){
	    maze[i]=lines.get(i);
	}
	for(int r=0; r<maze.length;r++){
	    for(int c=0; c<maze[r].length;c++){
		if(maze[r][c]=='S'){
		    if(startr == -1){
			startr=r;
			startc=c;
		    }else{
			System.out.println("Multiple 'S' found!");
			System.exit(0);
		    }
		}

		if(maze[r][c]=='E'){
		    //erase E
		    //maze[r][c]=' ';
		    if(endr == -1){
			endr=r;
			endc=c;
		    }else{
			System.out.println("Multiple 'E' found!");
			System.exit(0);
		    }
		}
	    }
	}
	if(startr == -1 || endr == -1){
	    System.out.println("Missing 'S' or 'E' from maze.");
	    System.exit(0);

	}

	/*
	  THIS IS AN IMPORTANT PART BECAUSE YOU WILL NEED TO CHANGE IT LATER!
	  The start/end Locations may need more information later when we add
	  other kinds of frontiers!
	*/
	end = new Location(endr,endc,null);
	start = new Location(startr,startc,null);
    }
    
    public String toStringColor(){
	return toStringColor(50);
    }

    public String toStringColor(int delay){
	try{
	    Thread.sleep(delay);
	}catch(InterruptedException e){

	}
	return HIDE_CURSOR+CLEAR_SCREEN+go(1,1)+colorize(toString())+SHOW_CURSOR;
    }

    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	for(int i = 0; i < maxr * maxc; i++){
	    int row = i/maxc;
	    int col = i%maxc;

	    char c =  maze[row][col];
	    ans+=c;
	    if( col == maxc-1 ){
		ans += "\n";
	    }

	}
	return ans + "\n";
    }

    public char get(int row,int col){
	return maze[row][col];
    }
    public void set(int row,int col, char n){
	maze[row][col] = n;
    }
    public static String colorize(String s){
	String ans = "";
	Scanner in = new Scanner(s);
	while(in.hasNext()){
	    String line ="";
	    for(char c : in.nextLine().toCharArray()){
		if(c == '#'){
		    line+= color(37,47)+c;
		}
		else if(c == '@'){
		    line+= color(33,40)+c;
		}
		else if(c == '?'){
		    line+= color(37,42)+c;
		}
		else if(c == '.'){
		    line+= color(36,40)+c;
		}
		else if(c == ' '){
		    line+= color(35,40)+c;
		}else{
		    line+=color(37,40)+c;
		}

	    }
	    ans += line+color(37,40)+"\n";
	}
	return ans;
    }

    public static void main(String[] args){
	
	Maze a = new Maze("data2.dat");

	Location b = new Location(1, 1, null);

	Location[] array = a.getNeighbors(b);

	for(int i = 0; i < array.length; i++){
	    System.out.println(array[i]);
	}
    }
    
}


/*
	int ecks = L.getX();
	int whys = L.getY();
	if(ecks >= maze.length || whys >= maze[0].length){
	    return null;
	}

	int[][] coordinates = { {L.getX(), L.getY() + 1}, {L.getX(), L.getY() - 1},
				   {L.getX() + 1, L.getY()}, {L.getX() - 1, L.getY()} };
	
	Location[] neighbors = new Location[4];
	int neighIndex = 0;
	
	for(int i = 0; i < 4; i++){
	    if(coordinates[i][0] >= 0 && coordinates[i][0] < maze.length &&
	       coordinates[i][1] >= 0 && coordinates[i][1] < maze[0].length){
		if(maze[coordinates[i][0]][coordinates[i][1]] == ' ' || maze[coordinates[i][0]][coordinates[i][1]] == 'E'){
		    neighbors[neighIndex] = new Location(coordinates[i][0], coordinates[i][1], L);
		    neighIndex++;
		}
	    }
	}

	for(int i = 0; i < 4; i++){
	    if(neighbors[i] != null){
		int xcor = neighbors[i].getX();
		int ycor = neighbors[i].getY();
		set(xcor, ycor, '?');
	    }
	}
	return neighbors;
	*/
