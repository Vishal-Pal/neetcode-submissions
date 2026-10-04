class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Integer.MIN_VALUE;
        for(int pile:piles){
            max = Math.max(max,pile);
        }
        int res = -1;
        while(min<=max){
            int mid = (min+max)/2;
            int hours = 0;
            for(int pile:piles){
                hours+=pile/mid;
                if(pile%mid!=0){
                    hours+=1;
                }
            }
            if(hours<=h){
                res = mid;
                max = mid-1;
            } else{
                min = mid+1;
            }
        }
        return res;
    }
}
