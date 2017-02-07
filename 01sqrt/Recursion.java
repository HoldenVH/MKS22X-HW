import java.lang.IllegalArgumentException;

public class Recursion{
    public static String name(){return "Higgins,Holden";}
    public static double sqrt(double n){
	if(n<=0){
	    throw new IllegalArgumentException();
	}
	return sh(n,1);
    }
    public static double sh(double n, double guess){
	double newGuess=.5*(n/guess+guess);
	if(doubleEquals(guess,newGuess,12)){
	    return newGuess;
	}
	return sh(n,newGuess);
    }
    public static boolean doubleEquals(double d1,double d2,int tolerance){
	return Math.abs(d1-d2)/((d1+d2)/2)<Math.pow(10,(-1*tolerance));
    }
}
