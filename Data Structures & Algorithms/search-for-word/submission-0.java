class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,word,i,j,m,n,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board,String word,int i,int j,int m,int n,int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || i>=m || j<0 || j>=n || board[i][j]!=word.charAt(idx)){
            return false;
        }
        char originalChar=board[i][j];
        board[i][j]='#'; 
        boolean found = dfs(board,word,i+1,j,m,n,idx+1)||
                        dfs(board,word,i-1,j,m,n,idx+1)||
                        dfs(board,word,i,j+1,m,n,idx+1)||
                        dfs(board,word,i,j-1,m,n,idx+1);
        board[i][j]=originalChar;
        return found;
    }
}
