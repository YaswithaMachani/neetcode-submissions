class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur =new ArrayList<>();
        backtrack(res,cur,0,nums);
        return res;
    }
    void backtrack(List<List<Integer>> res,List<Integer> cur,int idx,int[] nums){
        if(idx==nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[idx]);
        backtrack(res,cur,idx+1,nums);
        cur.remove(cur.size()-1);
        backtrack(res,cur,idx+1,nums);
    }
}
