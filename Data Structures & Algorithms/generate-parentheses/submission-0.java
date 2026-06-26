class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generate(n,res,0,0,"");
        return res;
    }
    void generate(int n,List<String> res,int open,int close,String r){
        if(open+close==2*n){
            res.add(r);
        }
        if(open<n){
            generate(n,res,open+1,close,r+"(");
        }
        if(close<open){
            generate(n,res,open,close+1,r+")");
        }
    }
}
