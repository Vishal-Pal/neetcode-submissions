class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // Use res to store the preproduct
        res[0]=1;
        for(int ind=1;ind<len;ind++){
            res[ind]=res[ind-1]*nums[ind-1];
        }
        // Use a variable to store the postproduct
        int postProduct = 1;
        for(int ind=len-1;ind>=0;ind--){
            res[ind]*=postProduct;
            postProduct*=nums[ind];
        }
        return res;
    }
}  
