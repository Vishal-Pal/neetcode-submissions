class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        // Instantiation
        int[] result = new int[len];
        // All numbers product except last
        int preProduct = 1;
        // All numbers product except zeroes
        int productExceptZero = 1;
        // Count of Zeroes
        int countZero = 0;

        // Calculate pre product, count of zeroes
        // and product of numbers except zero
        for(int i=0;i<len;i++){
            if(i!=len-1){
                preProduct *= nums[i];
            }
            if(nums[i]==0){
                countZero++;
            } else{
                productExceptZero*=nums[i];
            }
            if(countZero>1){
                return result;
            }
        }

        // Populate last element of result as the preproduct
        result[len-1] = preProduct;

        // Iterate to fill the result array
        for(int i=len-2;i>=0;i--){
            // For exactly one zero, only the zeroth
            // element will have non-zero product
            if(countZero == 1){
                if(nums[i]==0){
                    result[i] = productExceptZero;
                }
            } else{
                result[i]=(result[i+1]/nums[i])*nums[i+1];
            }
        }

        // Return result
        return result;
    }
}  
