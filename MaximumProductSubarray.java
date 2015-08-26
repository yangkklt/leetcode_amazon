public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n];
        int[] g = new int[n];
        f[0] = nums[0];
        g[0] = nums[0];
        int max = Math.max(f[0], g[0]);
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] * nums[i], Math.max(g[i - 1] * nums[i], nums[i]));
            g[i] = Math.min(g[i - 1] * nums[i], Math.min(f[i - 1] * nums[i], nums[i]));
            max = Math.max(f[i], max);
        }
        return max;
    }
}