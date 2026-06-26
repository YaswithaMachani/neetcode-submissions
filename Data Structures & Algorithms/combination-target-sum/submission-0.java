class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur =new ArrayList<>();
        backtrack(res,cur,0,nums,target);
        return res;
    }
    void backtrack(List<List<Integer>> res,List<Integer> cur,int idx,int[] nums,int target){
        int sum=0;
        for(int n:cur){
            sum+=n;
        }
        if(target==sum && cur.size()>0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(sum>target||idx>=nums.length){
            return;
        }
        cur.add(nums[idx]);
        backtrack(res,cur,idx,nums,target);
        cur.remove(cur.size()-1);
        backtrack(res,cur,idx+1,nums,target);
    }
}
