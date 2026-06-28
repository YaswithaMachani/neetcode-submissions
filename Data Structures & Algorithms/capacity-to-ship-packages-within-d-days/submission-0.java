class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0;
        int right=0;
        for(int num:weights){
            left=Math.max(left,num);
            right=right+num;
        }
        int res=right;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(canShip(mid,weights,days)){
                res=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return res;
    }
    boolean canShip(int capacity,int[] weights,int daysLimit){
        int daysUsed=1;
        int currentLoad=0;
        for(int w:weights){
            if(currentLoad+w>capacity){
                daysUsed++;
                currentLoad=w;
            }
            else{
                currentLoad+=w;
            }
        }
        return daysUsed<=daysLimit;
    }
}