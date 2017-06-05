import java.util.*;


public class StackCalc{
    public static double eval(String s){
	String[] items = s.split(" ");
	Stack<Double> stack = new Stack<Double>();
	for(int i = 0; i < items.length; i++){
	    if(isO(items[i])){
		stack.push(apply(stack.pop().toString(),stack.pop().toString(), items[i]));
	    }
	    else{
		stack.push(new Double(items[i]).doubleValue());
	    }
	}
	return new Double(stack.pop()).doubleValue();
    }
    private static double apply(String b, String a, String op){
	if(op.equals("+"))
	    return Double.parseDouble(a) + Double.parseDouble(b);
	if(op.equals("-"))
	    return Double.parseDouble(a) - Double.parseDouble(b);
	if(op.equals("*"))
	    return Double.parseDouble(a) * Double.parseDouble(b);
	if(op.equals("/"))
	    return Double.parseDouble(a) / Double.parseDouble(b);
	else
	    return Double.parseDouble(a) % Double.parseDouble(b);
    }
    private static boolean isO(String s){
	char a = s.charAt(0);
	return s.length()==1 &&
	    (a == '*' ||
	    a == '+' ||
	    a == '-' ||
	    a == '/' ||
	     a == '%');
	    
    }
}
