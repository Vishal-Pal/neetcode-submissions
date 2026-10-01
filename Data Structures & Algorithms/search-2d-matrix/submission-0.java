class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++){
            int[] arr = matrix[i];
            if(arr[0]>target){
                return false;
            }
            if(arr[0]<=target && target<=arr[n-1]){
                return binarySearch(arr, target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target){
        int start = 0, end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target){
                return true;
            } else if(arr[mid]<target){
                start=mid+1;
            } else{
                end=mid-1;
            }
        }
        return false;
    }
}
