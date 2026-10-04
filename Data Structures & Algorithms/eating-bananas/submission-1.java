class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // Minimum feasible speed
        int right = Arrays.stream(piles).max().getAsInt(); // Maximum practical speed
        int res = right;
        while(left<=right){
            int mid = (left+right)/2;
            int hours = 0;
            for(int pile:piles){
                hours+=pile/mid;
                if(pile%mid!=0){
                    hours+=1;
                }
            }
            if(hours<=h){
                res = mid;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return res;
    }
}
