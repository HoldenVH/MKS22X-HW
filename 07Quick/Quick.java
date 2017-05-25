import java.util.Random;

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
	    int current=a[i];
	    if(current<v){
		swap(a,i,lt);
		lt++;
		i++;
	    }
	    if(current>v){
		swap(a,i,gt);
		gt--;
	    }
	    if(current==v){
		i++;
	    }
	}
	return v;
    }

    public static void quicksort(int[] a){
    	if(a.length>0){
	    qsh(a,0,a.length-1);
	}
    }
    public static void qsh( int [] a, int start, int end){
	if(start>=end)return;

	Random rng=new Random();
	int v=a[start+rng.nextInt(end-start+1)];
	int lt=start;
	int i=start;
	int gt=end;
	int n1=0;
	int n2=0;
	while(i<gt){
	    int current=a[i];
	    if(current>v){
		swap(a,i,gt);
		gt--;
		n2++;
	    }
	    if(current<v){
		//if(lt+1<i){
		swap(a,i,lt);
		//}
		lt++;
		i++;
		n1++;

	    }
	    
	    if(current==v){
		i++;
	    }
	}
	//System.out.println(n1+" "+n2);
	if(a[gt]<v){
	    swap(a,gt,lt);
	    lt++;
	    i++;
	}
	if(lt-1>start){
	    //System.out.println(lt+" "+i+" "+start);
	    qsh(a,start,lt);
	}
	if(gt<end){
	    qsh(a,gt,end);
	}
    }

    public static void swap(int[] a, int p, int q){
	int holder=a[p];
	a[p]=a[q];
	a[q]=holder;
    }    
}
