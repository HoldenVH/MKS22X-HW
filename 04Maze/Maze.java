import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Maze{

    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */
    public Maze(String filename){
        File text = new File(filename);// can be a path"/full/path/to/file.txt" 
        try{
	    Scanner inf = new Scanner(text);
	
	int lineNumber = 1;
	String line="";
	while(inf.hasNextLine()){
            line = inf.nextLine();
	    lineNumber++;
	}
	maze=new char[lineNumber][line.length()];

	inf = new Scanner(text);
	lineNumber=0;
	while(inf.hasNextLine()){
            line = inf.nextLine();
	    for(int i=0;i<line.length();i++){
		maze[lineNumber][i]=line.charAt(i);
	    }
	    lineNumber++;
	}
	}
	catch(FileNotFoundException e){
	}
	
	animate=false;
    }
    
    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    public String toString(){
	String retStr="";
	for(int row=0;row<maze.length;row++){
	    for(int col=0;col<maze[0].length;col++){
		retStr+=Character.toString(maze[row][col]);
	    }
	    retStr+="\n";
	}
	return retStr;
    }
       

    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */

    
    public boolean solve(){
            int startr=-1,startc=-1;
            for(int row=0;row<maze.length;row++){
		for(int col=0;col<maze[0].length;col++){
		    if(maze[row][col]=='S'){
			startr=row;
	   		startc=col;
		    }
		}
	    }
            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	maze[row][col]='@';
	if(maze[row+1][col]=='E'
	   ||maze[row-1][col]=='E'
	   ||maze[row][col+1]=='E'
	   ||maze[row][col-1]=='E'){
	    return true;
	}
	
	if(maze[row+1][col]==' '){
	    if(solve(row+1,col)){
		return true;
	    }
	    else{
		maze[row+1][col]='.';
	    }
	}
	if(maze[row-1][col]==' '){
	    if(solve(row-1,col)){
		return true;
	    }
	    else{
		maze[row-1][col]='.';
	    }
	}
	if(maze[row][col+1]==' '){
	    if(solve(row,col+1)){
		return true;
	    }
	    else{
		maze[row][col+1]='.';
	    }
	}
	if(maze[row][col-1]==' '){
	    if(solve(row,col-1)){
		return true;
	    }
	    else{
		maze[row][col-1]='.';
	    }
	}
	
        return false; //so it compiles
    }

}
