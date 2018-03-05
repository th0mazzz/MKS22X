import java.util.*;
import java.io.*;
public class Driver{

    public static void main(String[]args){

	try{
	
	    Maze f = new Maze("data3.dat");//true animates the maze.
        
	    f.setAnimate(true);
	    System.out.println("Number of @'s: " + f.solve());

	    System.out.println(f);
	
	}catch(FileNotFoundException e){
	    System.out.println("Caught FileNotFoundException, please recheck your input");
	}
    }
}
