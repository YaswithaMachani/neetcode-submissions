class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0,m,n);
            }
            if(board[i][n-1]=='O'){
                dfs(board,i,n-1,m,n);
            }
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j,m,n);
            }
            if(board[m-1][j]=='O'){
                dfs(board,m-1,j,m,n);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public static void dfs(char[][] board,int i,int j,int m,int n){
        board[i][j]='#';
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] d:dir){
            int nr=i+d[0];
            int nc=j+d[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O'){
                dfs(board,nr,nc,m,n);
            }
        }
    }
}
