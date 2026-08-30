class Solution {
    public int shipWithinDays(int[] weights, int d) {
        int left=0;
        int right=0;
        for(int weight:weights){
            left=Math.max(left,weight);
            right+=weight;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            int days=daysNeeded(weights,mid);
            if(days<=d){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
    int daysNeeded(int[]weights,int capacity){
        int days=1;
        int currentLoad=0;
        for(int weight:weights){
            if(currentLoad+weight>capacity){
                days++;
                currentLoad=weight;
            }
            else{
                currentLoad+=weight;
            }
        }
        return days;
    }
}

