public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = triangle.get(n - 1).get(i);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                cost[j] = Math.min(cost[j], cost[j + 1]) + triangle.get(i).get(j); 
            }
        }
        
        return cost[0];
    }
}