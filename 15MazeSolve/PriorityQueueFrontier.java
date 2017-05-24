import java.util.*;

public class PriorityQueueFrontier implements Frontier {
    private ArrayList<Location> heap;
    private int constant;
    private int size;
    
    public PriorityQueueFrontier() {
	heap = new ArrayList<Location>();
	heap.add(new Location(0, 0, null, 0, 0, false));
	constant = 1;
	size = 0;
    }
    
    public PriorityQueueFrontier(boolean max) {
	this();
	if (!max) constant = -1;
    }

    public int getSize() {
	return size;
    }

    public void add(Location loc) {
	heap.add(loc);
	size++;
	int child = size;
	int parent = child / 2;
	while (parent >= 1 && compare(heap.get(parent), heap.get(child)) < 0) {
	    swap(parent, child);
	    child = parent;
	    parent = child / 2;
	}
    }

    public Location remove() {
	if (size == 0) throw new NoSuchElementException("Empty!");
	else {
	    Location toRemove = heap.get(1);
	    heap.set(1, heap.get(size));
	    heap.remove(size);
	    size--;
	    moveDown();
	    return toRemove;
	}
    }

    private void swap(int ind1, int ind2) {
	Location temp = heap.get(ind1);
	heap.set(ind1, heap.get(ind2));
	heap.set(ind2, temp);
    }

    public int compare(Location loc1, Location loc2) {
	return loc1.compareTo(loc2) * constant;
    }
    
    public Location peek() {
	if (size == 0) throw new IndexOutOfBoundsException("Empty!");
	else return heap.get(1);
    }
    
    private void moveDown() {
	int parent = 1;
	int child = 2;
	while (child <= size && compare(heap.get(parent), heap.get(child)) < 0) {
	    if (compare(heap.get(child), heap.get(child+1)) < 0) {
		child++;
		swap(parent, child);
		parent = child;
		child = parent * 2 - 1;
	    }
	    else {
		swap(parent, child);
		parent = child;
		child = parent * 2;
	    }
	}
    }

    public Location next() {
	return remove();
    }
}
