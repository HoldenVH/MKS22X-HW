public class Quick{
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

    public static int part ( int [] a, int start, int end){
	int v=a[start];
	int lt=start;
	int i=start+1;
	int gt=end;
	while(i<gt){
	    if(a[i]<v){
		swap(a,i,lt);
		lt++;
		i++;
	    }
	    if(a[i]>v){
		swap(a,i,gt);
		gt--;
	    }
	    if(a[i]==v){
		i++;
	    }
	}
	return v;
    }

    public static void quickSort(int[] a){
	qsh(a,0,a.length-1);
    }
    public static void qsh( int [] a, int start, int end){
	int v=a[start];
	int lt=start;
	int i=start+1;
	int gt=end;
	while(i<gt){
	    if(a[i]<v){
		swap(a,i,lt);
		lt++;
		i++;
	    }
	    if(a[i]>v){
		swap(a,i,gt);
		gt--;
	    }
	    if(a[i]==v){
		i++;
	    }
	}
	if(a[gt]<v){
	    swap(a,gt,lt);
	    lt++;
	    i++;
	}
	for(int n=0;n<a.length;n++){
	    System.out.print(a[n]+",");
	}
	System.out.println("\n"+v+"\n"+lt+","+start+"\n"+gt+","+end);
	if(lt-1>start){
	    qsh(a,start,lt);
	}
	if(gt<end){
	    System.out.println("GT");
	    qsh(a,gt,end);
	}
    }

    public static void swap(int[] a, int p, int q){
	int holder=a[p];
	a[p]=a[q];
	a[q]=holder;
    }
    
    public static void main(String[] args){
	int[] arr={4,9999,5,0,4,999,2,6,1,999999,3,4};
	quickSort(arr);
	for(int i=0;i<arr.length;i++){
	    System.out.print(arr[i]+",");
	}
    }
    
}
