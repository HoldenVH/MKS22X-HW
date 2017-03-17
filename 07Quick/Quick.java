public class Quick{
    public static int part ( int [] data, int start, int end){
	int pivot=data[end];
	int swaps=0;
	int loc=start;
	while(loc<=end){
	    if(data[loc]<pivot){
		int holder = data[start+swaps];
		data[start+swaps]=data[loc];
		data[loc]=holder;
		swaps++;
	    }
		loc++;
	}
	int holder=data[start+swaps];
	data[start+swaps]=pivot;
	data[end]=holder;
	return start+swaps;
    }
    public static int quickselect(int []data, int k){
	return qHelp(data,k,0,data.length-1);
    }
    private static int qHelp(int[] data, int k, int s, int e){
	int piv=part(data,s,e);
	if(piv==k){
	    return data[piv];
	}
	if(piv>k){
	    if(piv==e){
		return qHelp(data,k,s,piv-1);
	    }
	    else{
		return qHelp(data,k,s,piv);
	    }
	}
	else{
	    if(piv==s){
		return qHelp(data,k,piv+1,e);
	    }
	    else{
		return qHelp(data,k,piv,e);
	    }
	}
    }
    /*
    public static void main(String[] args){
	int[] arr={9999,5,0,4,999,2,6,1,999999,3,4};
	System.out.println(quickselect(arr,8));
	for(int i=0;i<arr.length;i++){
	    System.out.print(arr[i]+",");
	}
    }
    */
}
