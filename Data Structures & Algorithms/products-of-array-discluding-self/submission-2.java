class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        // Instantiation
        int[] result = new int[len];

        // Consider result as pre product array in first iteration
        result[0]=1;

        // Filling pre product array
        for(int i=1;i<len;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        
        // Will be calculated on the fly in second iteration
        int postProduct = nums[len-1];

        // Iterate to fill the result array
        for(int i=len-2;i>=0;i--){
            result[i]*=postProduct;
            postProduct*=nums[i];
        }

        // Return result
        return result;
    }
}  
