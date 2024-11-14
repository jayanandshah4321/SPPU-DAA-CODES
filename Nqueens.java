public class queens {
    public static boolean issafe(char board[][],int row,int col){
        //column wali conditon
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //left diagonal up condition
        for(int i=row-1, j=col-1;i>=0&&j>=0;j--,i--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //right digonal up condition
        for(int i=row-1,j=col+1;i>=0&&j< board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void nqueens( char board[][],int row){
        //base case
        if(row==board.length){
            printBoard(board);
            return;
        }
        //kaam

        for(int j=0;j<board.length;j++){
            if(issafe(board,row,j)){
                board[row][j]='Q';
                nqueens(board,row+1);//function call
                board[row][j]='x';//backtracking
            }

        }
    }
    public static void printBoard(char board[][]){
        System.out.println("------chessboard----");
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n=6;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='x';
            }
        }
        nqueens(board,0);
    }
}
    
