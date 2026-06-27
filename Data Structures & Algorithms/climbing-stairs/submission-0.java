class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int num=climb(dp,n);
        return num;
        
    }
    int climb(int[] dp,int n){
        if(n==0||n==1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=climb(dp,n-1)+climb(dp,n-2);
    }
    
}
