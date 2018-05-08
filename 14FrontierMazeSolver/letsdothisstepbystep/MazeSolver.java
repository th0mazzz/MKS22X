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

	    Location next = frontier.next();

	    if(next.getX() == end.getX() && next.getY() == end.getY()){

		//if it is the end
		
	    }else{
		
		Location[] neighbors = maze.getNeighbors(next);
		for(int i = 0; i < neighbors.length; i++){

		    maze.set(next.getX(), next.getY(), '.');
		    frontier.add(neighbors[i]);
		    
		}
	    }
	}
	
	
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}
