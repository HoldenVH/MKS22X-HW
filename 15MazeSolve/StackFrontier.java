import java.util.Stack;

public class StackFrontier implements Frontier {
    private Stack<Location> fStack;
    
    public StackFrontier() {
	fStack = new Stack<Location>();
    }

    public int getSize() {
	return fStack.size();
    }

    public void add(Location loc) {
	fStack.push(loc);
    }

    public Location next() {
	return fStack.pop();
    }
}
