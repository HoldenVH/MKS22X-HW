import java.util.*;

public class StackCalc{
    public static double eval(String s){
	String[] info = s.split(" ");
	Stack<Double> stk = new Stack<Double>();
	for(int i = 0; i < info.length; i++){
	    if(isO(info[i])){
		stk.push(apply(stk.pop().toString(),
			       stk.pop().toString(), info[i]));
	    }
	    else{
		stk.push(new Double(info[i]).doubleValue());
	    }
	}
	return new Double(stk.pop()).doubleValue();
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
	return a == '*' ||
	    a == '+' ||
	    a == '-' ||
	    a == '/' ||
	    a == '%';
    }
    public static void main(String[]args){
	System.out.println(eval("10 28 24 4 / % *"));
    }
}
public static double eval(string){
    tokens=s.split(" ");
    values=new stack<Integer>;
    for(int i=0;i<tokens.length;i++){
	if(isOp(tokens[i])){
	    //apply(op,b,a)
	    apply(tokens[i],values.pop(),values.pop());
	}
	else{
	    values.push(Integer.parseInt(tokens[i]));
	}
    }
    return values.pop();
}
