public class Merge{
    public static void sortedMerge(int[] a,int[] b,int[] c){
	int A,B,C;
	A=B=C=0;
	while(A<a.length&&B<b.length){
	    if(a[A]<b[B]){
		c[C]=a[A];
		A++;
	    }
	    else{c[C]=b[B];}
	    C++;
	}
	while(A<a.length){
	    c[C]=a[A];
	    A++;
	}
	while(B<b.length){
	    c[C]=b[B];
	    B++;
	}
    }

    public static void mergesort(int[] a){
	mergesort(a,0,a.length-1);
    }
    public static void mergesort(int[] a,int l, int r){//r & l are inclusive
	//print2(a);
	//System.out.println("\nL:"+l+",      R:"+r);
	if(l+1==r){
	    if(a[r]<a[l]) swap(a,l,r);
	}
	if(l+1<r){
	    mergesort(a,((l+r)/2)+1,r);
	    mergesort(a,l,(l+r)/2);
	    internalSortedMerge(a,l,(l+r)/2,((l+r)/2)+1,r);
	}
    }
    public static void internalSortedMerge(int[] a,int ll, int lr, int rl, int rr){//ll<lr<rl<rr,lr+1=rl
        int[] temp=new int[rr-ll+1];
	int L=ll;
	int R=rl;
	int C=0;
	while(L<=lr&&R<=rr){
	    if(a[L]<a[R]){
		temp[C]=a[L];
		L++;
	    }
	    else{
		temp[C]=a[R];
		R++;
	    }
	    C++;
	}
	while(L<=lr){
	    temp[C]=a[L];
	    L++;
	    C++;
	}
	while(R<=rr){
	    temp[C]=a[R];
	    R++;
	    C++;
	}
	for(int i=0;i+ll<=rr;i++){
	    a[i+ll]=temp[i];
	}
    }

    
    public static void swap(int[] a, int p, int q){
	int holder=a[p];
	a[p]=a[q];
	a[q]=holder;
    }
    public static void print2(int[] p){
	for(int i=0;i<p.length;i++){
	    System.out.print(p[i]+",");
	}
	System.out.println();
    }
    /*
    public static void main(String[] args){
	int[] arr={4,9999,5,0,4,999,2,6,1,999999,3,4};
	mergeSort(arr,0,arr.length-1);
	//int[] arg={1,3,6,7,999999,2,4,5,110};
	//internalSortedMerge(arg,0,4,5,8);
	print2(arr);
	}*/
}
