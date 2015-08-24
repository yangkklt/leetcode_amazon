public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int cursor = 0;
        int curr = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (cursor = colStart; cursor <= colEnd; cursor++) {
                matrix[rowStart][cursor] = curr++;
            }
            if (++rowStart > rowEnd || colStart > colEnd) {
                break;
            }
            
            for (cursor = rowStart; cursor <= rowEnd; cursor++) {
                matrix[cursor][colEnd] = curr++;
            }
            if (rowStart > rowEnd || colStart > --colEnd) {
                break;
            }
            
            for (cursor = colEnd; cursor >= colStart; cursor--) {
                matrix[rowEnd][cursor] = curr++;;
            }
            if (rowStart > --rowEnd || colStart > colEnd) {
                break;
            }
            
            for (cursor = rowEnd; cursor >= rowStart; cursor--) {
                matrix[cursor][colStart] = curr++;
            }
            if (rowStart > rowEnd || ++colStart > colEnd) {
                break;
            }
        }
        return matrix;        
    }
}