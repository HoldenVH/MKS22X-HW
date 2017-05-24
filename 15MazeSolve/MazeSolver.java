import java.util.*;

public class MazeSolver {
    private Maze maze;
    private boolean animate;
    private boolean aStar;

    public MazeSolver(String filename) {
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate) {
	maze = new Maze(filename);
	this.animate = animate;
    }

    public void solve() {
	solve(1);
    }
    
    public void solve(int style) {
	System.out.println(Maze.colorize(maze.toString()));
	Frontier frontier;
	if (style > 3 || style < 0) throw new IllegalArgumentException("Number not valid!");
	
	if (style == 0) { //
	    frontier = new StackFrontier();
	}
	else if (style == 1) {
	    frontier = new QueueFrontier();
	}
	else if (style == 2) { //
	    frontier = new PriorityQueueFrontier(false);
	}
	else {
	    frontier = new PriorityQueueFrontier(false);
	    aStar = true;
	}

	frontier.add(maze.getStart());
	int startRow = maze.getStart().getRow();
	int startCol = maze.getStart().getCol();
	int endRow = maze.getEnd().getRow();
	int endCol = maze.getEnd().getCol();

	while (frontier.getSize() != 0) {
	    Location current = frontier.next();
	    int dist = Math.abs(endRow - current.getRow()) + Math.abs(endCol - current.getCol());
	    if (dist == 0) return;
	    for (int i = 1;i < 5;i++) {
		int row = rowCal(current.getRow(), i);
		int col = colCal(current.getCol(), i);
		if (row > maze.getMaxR() || col > maze.getMaxC()) break;
		if (maze.get(row, col) == ' ') {
		    int startDist = Math.abs(startRow - row) + Math.abs(startCol - col);
		    int endDist = Math.abs(endRow - row) + Math.abs(endCol - col);
		    frontier.add(new Location(row, col, current, startDist, endDist, aStar));
		    maze.set(row, col, '?');
		}
	    }
	    maze.set(current.getRow(), current.getCol(), '.');
	    System.out.println(this.toString());
	}
    }

    public int rowCal(int original, int i) {
	if (i == 1) return original + 1;
	else if (i == 2) return original - 1;
	else {return original;}
    }

    public int colCal(int original, int i) {
	if (i == 3) return original + 1;
	else if (i == 4) return original - 1;
	else {return original;}
    }

    public String toString() {
	if (animate) {
	    return maze.toString(100);
	}
	return maze.toString();
    }
    public static void main(String[] args){
	MazeSolver m=new MazeSolver(args[0],true);
	m.solve(2);
	System.out.println(m);
    }
}
