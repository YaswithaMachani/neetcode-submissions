class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int n=nums.length;
        for(Map.Entry<Integer,Integer> hmap:map.entrySet()){
            if(hmap.getValue()>n/3){
                list.add(hmap.getKey());
            }
        }
        return list;
    }
}