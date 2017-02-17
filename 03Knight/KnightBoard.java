public class KnightBoard{
    private int[][] board;
    private int[] _MOVES=new int[]{1,2,-1,2,-1,-2,1,-2,2,1,-2,1,-2,-1,2,-1};
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";

    
    public KnightBoard(int startingRows,int startingCols) {
	board=new int[startingCols][startingRows];
	for(int row=0;row<board[0].length;row++){
	    for(int col=0;col<board.length;col++){
		board[col][row]=0;
	    }
	}
    }

    public String toString(){ //blank if you never called solve or when there is no solution
	String s="";
	for(int row=0;row<board[0].length;row++){
	    for(int col=0;col<board.length;col++){
		if(board[col][row]<10){
		    s+=" ";
		}
		s+=board[col][row]+" ";
	    }
	    s+="\n";
	}
	return s;
    }
    private static void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    private static String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }



    
    public void solve() {
	System.out.println(solveH(0,0,1));
    }

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight
	/*========================test=================================
	System.out.println(CLEAR_SCREEN);
	//go(1,1);
	System.out.println(toString());
	wait(1000);
	//*///=================================================

	board[col][row]=level;
	if(level==board.length*board[0].length){
	    return true;
	}
	
	for(int loc=0;loc<_MOVES.length;loc+=2){
	    if(!(row+_MOVES[loc]<0||row+_MOVES[loc]>=board[0].length
		 ||col+_MOVES[loc+1]<0||col+_MOVES[loc+1]>=board.length)
	       && board[col+_MOVES[loc+1]][row+_MOVES[loc]]==0
	       && solveH(row+_MOVES[loc],col+_MOVES[loc+1],level+1)){
		   return true;
	       }
	}
	board[col][row]=0;
	return false;

    }
    public static void main(String[] args){
	
	System.out.println(HIDE_CURSOR);
	KnightBoard kb=new KnightBoard(6,5);
	kb.solve();
	System.out.println(kb);
	
    }
}
