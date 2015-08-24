public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return res;
        }
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;
        
        int cursor = 0;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (cursor = colStart; cursor <= colEnd; cursor++) {
                res.add(matrix[rowStart][cursor]);
            }
            if (++rowStart > rowEnd || colStart > colEnd) {
                break;
            }
            
            for (cursor = rowStart; cursor <= rowEnd; cursor++) {
                res.add(matrix[cursor][colEnd]);
            }
            if (rowStart > rowEnd || colStart > --colEnd) {
                break;
            }
            
            for (cursor = colEnd; cursor >= colStart; cursor--) {
                res.add(matrix[rowEnd][cursor]);
            }
            if (rowStart > --rowEnd || colStart > colEnd) {
                break;
            }
            
            for (cursor = rowEnd; cursor >= rowStart; cursor--) {
                res.add(matrix[cursor][colStart]);
            }
            if (rowStart > rowEnd || ++colStart > colEnd) {
                break;
            }
        }
        return res;
    }
}