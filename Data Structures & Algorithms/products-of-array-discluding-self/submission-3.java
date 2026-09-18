class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];

        // Consider res as preProduct for 1st iteration
        res[0]=1;
        for(int i=1;i<len;i++){
            res[i]=res[i-1]*nums[i-1];
        }

        int postProduct = 1;
        // Evaluate res in 2nd iteration
        for(int i=len-1;i>=0;i--){
            res[i]*=postProduct; // preproduct*postproduct
            postProduct*=nums[i]; // Update postproduct, consider current element in it
        }

        return res;
    }
}  
