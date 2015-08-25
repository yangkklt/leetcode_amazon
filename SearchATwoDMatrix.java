public class SearchATwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            } else if (matrix[mid / n][mid % n] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        return matrix[start / n][start % n] == target || matrix[end / n][end % n] == target;
    }
}