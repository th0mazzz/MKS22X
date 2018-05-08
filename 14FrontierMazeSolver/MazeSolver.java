public class MazeSolver{
    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText){
	maze = new Maze(mazeText);
    }

    //Default to BFS
    public boolean solve(){ return solve(0); }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    public boolean solve(int mode){

	if(mode == 0){
	    frontier = new FrontierQueue();
	}
	if(mode == 1){
	    frontier = new FrontierStack();
	}

	Location start = maze.getStart();
	Location end = maze.getEnd();
	    
	frontier.add(start);

	while(frontier.hasNext()){
	    frontier.add(frontier.next());
	}
	
	
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}
