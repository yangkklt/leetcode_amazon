public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHasZero = false;
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (rowHasZero) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if (colHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}