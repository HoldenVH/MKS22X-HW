import java.util.*;

public class MyHeap{
    boolean MyHeap;
    ArrayList<Integer> heap=new ArrayList<Integer>();

    MyHeap(boolean max){
	MyHeap=max;
	heap.add(null);
    }//- construct empty max heap
    
    public void add(Integer s){
	int index=heap.size();
	heap.add(s);
	int i=-1;
	if(MyHeap){
	    i=1;
	}
	if(index>1){
	    while(index>1&& i*s.compareTo(heap.get(index/2))>0){
		pushUp(index);
		index/=2;
	    }
	}
    }
    public Integer remove(){
	
	Integer rmv=heap.get(1);
	if(heap.size()>2){
	   heap.set(1,heap.remove(heap.size()-1));
	}
	int index=1;
	
	int i=-1;
	if(MyHeap){
	    i=1;
	}

	while(heap.size()>index*2+1 && i*heap.get(index).compareTo(heap.get(index*2))>0 ||
	      heap.size()>index*2+1 && i*heap.get(index).compareTo(heap.get(index*2+1))>0){
	    if(i*heap.get(index*2).compareTo(heap.get(index*2+1))>0){
		pushUp(index*2);
		index*=2;
	    }
	    else{
		pushUp(index*2+1);
		index=index*2+1;
	    }
	}
	return rmv;
    }
    public Integer peek(){
	return heap.get(1);
    }

    private void pushUp(int i){
	heap.set(i,heap.set(i/2, heap.get(i)));
    }
    //private pushDown(int i){    }
    public static void main(String[] arg){
	/*	MyHeap muhHeap= new MyHeap();
	for(int l='a';l<='z';l++){
	    muhHeap.add(Character.toString((char)l));
	}
	for(int i=1;i< muhHeap.heap.size();i++){
	    System.out.print((int)muhHeap.heap.get(i).charAt(0)+" ");
	    if(i==1||i==3||i==7||i==15||i==31){
		System.out.println();
	    }
	}
	*/
    }
}
