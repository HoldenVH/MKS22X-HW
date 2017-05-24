import java.util.ArrayList;

public class QueueFrontier implements Frontier {
    private ArrayList<Location> fQueue;

    public QueueFrontier() {
	fQueue = new ArrayList<Location>();
    }

    public int getSize() {
	return fQueue.size();
    }
    
    public void add(Location loc) {
	fQueue.add(0, loc);
    }

    public Location next() {
	return fQueue.remove(getSize() - 1);
    }
}
