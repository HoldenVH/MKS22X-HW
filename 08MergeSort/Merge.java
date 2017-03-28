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

    public static void mergeSort(int[] a,int l, int r){//r & l are inclusive
	for(int i=l;i<=r;i++){
	    System.out.print(a[i]+",");
	}
	System.out.println("\nL:"+l+",      R:"+r);
	if(l+1==r){
	    if(a[r]>a[l]) swap(a,l,r);
	}
	if(l+1<r){
	    mergeSort(a,((l+r)/2)+1,r);
	    mergeSort(a,l,(l+r)/2);
	    internalSortedMerge(a,l,(l+r)/2,((l+r)/2)+1,r);
	}
    }
    public static void internalSortedMerge(int[] a,int ll, int lr, int rl, int rr){//ll<lr<rl<rr,lr+1=rl
        int[] temp=new int[rr-ll+2];
	int L=ll;
	int 
	while(L<=lr&&R<=rr){
	    if(a[L]<a[R]){
		temp[]=a[];
		A++;
	    }
	    else{c[C]=b[B];}
	    C++;
	}
	while(L<=lr){
	    c[C]=a[A];
	    A++;
	}
	while(R<=rr){
	    c[C]=b[B];
	    B++;
	}
    }

    
    public static void swap(int[] a, int p, int q){
	int holder=a[p];
	a[p]=a[q];
	a[q]=holder;
    }
    public static void main(String[] args){
	int[] arr={4,9999,5,0,4,999,2,6,1,999999,3,4};
	mergeSort(arr,0,arr.length-1);
	for(int i=0;i<arr.length;i++){
	    System.out.print(arr[i]+",");
	}
    }
}
