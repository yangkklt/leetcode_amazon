public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                res = Math.min(res, j - i);
            }
            sum -= nums[i];
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}