import java.util.*;

public class RunningMedian{
    MyHeap less=new MyHeap(true);
    MyHeap more=new MyHeap(false);
    int lessSize;
    int moreSize;

    public RunningMedian(){
	lessSize=0;
	moreSize=0;
    }
    
    public void add(int n){
	if(n>getMedian()){
	    more.add(n);
	    moreSize++;
	}
	else {
	    less.add(n);
	    lessSize++;
	}
	if(moreSize+1<lessSize){
	    more.add(less.remove());
	    lessSize--;
	    moreSize++;
	}
	if(lessSize+1<moreSize){
	    less.add(more.remove());
	    moreSize++;
	    lessSize--;
	}
    }
    public double getMedian(){
	if(lessSize==0&&moreSize==0){
	    return 0;
	}
	if(lessSize>moreSize){
	    return less.peek();
	}
	if(moreSize>lessSize){
	    return more.peek();
	}
	else{
	    return (more.peek()+less.peek())/2;
	}
    }
    public static void main(String[] args){
	RunningMedian Michael = new RunningMedian();
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	for(int i = 0; i < 50; i++){
	    int s = (int)(Math.random() * 101);
	    nums.add(s);
	    Collections.sort(nums);
	    Michael.add(s);
	    System.out.println(nums);
	    System.out.println(Michael.getMedian());
	}
    }
}
