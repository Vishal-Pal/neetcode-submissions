class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int startRow = 0, endRow = m-1;
        int startCol = 0, endCol = n-1;
        while(startRow<=endRow && startCol<=endCol){
            int midRow = (startRow+endRow)/2;
            int midCol = (startCol+endCol)/2;
            int num = matrix[midRow][midCol];
            if(num == target){
                return true;
            } else if(num > target){
                if(matrix[midRow][0]<=target){
                    endCol = midCol-1;
                } else{
                    endRow = midRow-1;
                }
            } else{
                if(target<=matrix[midRow][n-1]){
                    startCol = midCol+1;
                } else{
                    startRow = midRow+1;
                }
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
