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

    /*

      adds start to frontier
      while frontier has next
      if element is the end {
           while getPrev is not null
	   set all getPrev values to '@'
       return true
      }else{
          remove first element in frontier, add its neighbors to the back
	  set the location to a '.'
      }
      if all else fails return false :D
	 
     */
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

	    System.out.println(frontier); //print
	    
	    Location next = frontier.next();

	    if(maze.get(next.getX(), next.getY()) == 'E'){

		Location prev = next.getPrev();
		while(prev.getPrev() != null){
		    maze.set(prev.getX(), prev.getY(), '@');
		    System.out.println(maze); //print statement
		    try {
			Thread.sleep(100);
		    }
		    catch (InterruptedException e) {
		    }
		    maze.clearTerminal();
		    prev = prev.getPrev();
		}

		System.out.println(maze);
		
		return true;
		
	    }else{
		if(maze.get(next.getX(), next.getY()) != 'S'){
		    maze.set(next.getX(), next.getY(), '.');
		}

		Location[] neighs = maze.getNeighbors(next);
		for(int i = 0; i < neighs.length; i++){
		    frontier.add(neighs[i]);
		}

		System.out.println(maze); //another one
		try {
		    Thread.sleep(50);
		}
		catch (InterruptedException e) {
		}
		maze.clearTerminal();
	    }
	    
	}
	
	return false;
    }
    

    public String toString(){
	return maze.toString();
    }
}
