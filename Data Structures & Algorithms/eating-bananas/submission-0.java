class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        int result=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canEatAll(piles,h,mid)){
                result=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return result;
    }
    public boolean canEatAll(int[] piles,int h,int mid){
        long totalHours=0;
        for(int pile:piles){
            totalHours+=(pile+mid-1)/mid;
        }
        return totalHours<=h;
    }
}
