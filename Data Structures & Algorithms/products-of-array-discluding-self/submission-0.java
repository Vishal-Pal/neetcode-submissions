class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        // Instantiation
        int[] result = new int[len];
        int[] preProduct = new int[len];
        int[] postProduct = new int[len];
        
        // Initial values
        preProduct[0]=1;
        postProduct[len-1]=1;

        // Populate preProduct
        for(int i=1;i<len;i++){
            preProduct[i]=preProduct[i-1]*nums[i-1];
        }

        // Populate postProduct
        for(int i=len-2;i>=0;i--){
            postProduct[i]=postProduct[i+1]*nums[i+1];
        }

        // Populate result
        for(int i=0;i<len;i++){
            result[i]=preProduct[i]*postProduct[i];
        }

        // Return result
        return result;
    }
}  
