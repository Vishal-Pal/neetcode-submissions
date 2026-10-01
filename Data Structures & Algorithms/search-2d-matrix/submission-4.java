class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m*n-1;
        while(start<=end){
            int mid = (start+end)/2;
            int row = mid/n;
            int col = mid%n;
            int num = matrix[row][col];
            if(num == target){
                return true;
            } else if(num<target){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        return false;
    }
}
