class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cur =new ArrayList<>();
        backtrack(res,cur,0,candidates,target);
        return res;
    }
    void backtrack(List<List<Integer>> res,List<Integer> cur,int idx,int[] nums,int target){
        int sum=0;
        for(int n:cur){
            sum+=n;
        }
        if(target==sum){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(sum>target||idx>=nums.length){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]) continue;
            cur.add(nums[i]);
            backtrack(res,cur,i+1,nums,target);
            cur.remove(cur.size()-1);
        }
    }
}
