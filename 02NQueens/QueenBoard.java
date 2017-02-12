public class QueenBoard{

    //vars:
    private int[][] board;
    private int solutionCount;

    public QueenBoard(int size){
	board=new int[size][size];
	for(int row=0;row<board.length;row++){
	    for(int col=0;col<board.length;col++){
		board[row][col]=0;
	    }
	}
	solutionCount=-1;   
    }
    
    private boolean solve(int col){
	if(col==board.length){
	    return true;
	}
	for(int row=0;row<board.length;row++){
	    if(board[row][col]==0){
	        placeQueen(row, col);
		if(solve(col+1)){
		    System.out.println(toString());
		    return true;
		}
		removeQueen(row,col);
	    }
	}
	return false;
    }

    private int countSolsR(int col){
	if(col==board.length){
	    return 1;
	}
	int sols=0;
	for(int row=0;row<board.length;row++){
	    if(board[row][col]==0){
		placeQueen(row, col);
		sols+=countSolsR(col+1);
		removeQueen(row, col);
	    }
	}
	return sols;
    }

    private void placeQueen(int row, int column){
	board[row][column]=-1;
	for(int i=1;i<board.length-column;i++){
	    if(row+i<board.length){
		board[row+i][column+i]++;
	       }
	    board[row][column+i]++;
	    if(row-i>=0){
		board[row-i][column+i]++;
	    }
	}
    }

    private void removeQueen(int row, int column){
	board[row][column]=0;
	for(int i=1;i<board.length-column;i++){
	    if(row+i<board.length){
		board[row+i][column+i]--;
	       }
	    board[row][column+i]--;
	    if(row-i>=0){
		board[row-i][column+i]--;
	    }
	}
    }

    public int getSolutions(){
	return solutionCount;
    }
    public void countSolutions(){
	for(int row=0;row<board.length;row++){
	    for(int col=0;col<board.length;col++){
		board[row][col]=0;
	    }
	}
	solutionCount=countSolsR(0);
    }
    public boolean solve(){
	return solve(0);
    }
    public String toString(){
	String retStr="";
	for(int row=0;row<board.length;row++){
	    for(int col=0;col<board.length;col++){
		if(board[row][col]>=0){
		    retStr+=" ";
		}
		retStr+=board[row][col]+" ";
	    }
	    retStr+="\n";
	}
	return retStr;
    }

    public static void main(String[] args){
	QueenBoard eight=new QueenBoard(8);
	eight.solve();
	eight.countSolutions();
	System.out.println(eight.getSolutions());
    }
}


