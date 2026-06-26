class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        permutations(res,0,nums);
        return res;
    }
    void permutations(List<List<Integer>> res,int idx,int[] nums){
        if(idx==nums.length){
            List<Integer> cur=new ArrayList<>();
            for(int n:nums) {
                cur.add(n);
            }
            res.add(cur);
            return;
        }
        for(int i=idx;i<nums.length;i++){
            swap(nums,i,idx);  
            permutations(res,idx+1,nums);
            swap(nums,i,idx);
        }
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
