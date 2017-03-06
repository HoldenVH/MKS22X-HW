public class KnightBoard{
    private int[][] board;
    private int[] _MOVES=new int[]{
	1,2,
	-1,2,
	-1,-2,
	1,-2,
	2,1,
	-2,1,
	-2,-1,
	2,-1};
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
    
    public void solve() {
	System.out.println(solveH(0,0,1));
    }

    private boolean solveH(int row ,int col, int level){ // level is the # of the knight

	board[col][row]=level;
	if(level==board.length*board[0].length){
	    return true;
	}
	int r=0;
	int c=0;
	for(int loc=0;loc<_MOVES.length;loc+=2){
	    r=row+_MOVES[loc];
	    c=col+_MOVES[loc+1];
	    if(!(r<0||r>=board[0].length||c<0||c>=board.length)&& board[c][r]==0
	       && solveH(r,c,level+1)){
		   return true;
	       }
	}
	board[col][row]=0;
	return false;
    }
}
