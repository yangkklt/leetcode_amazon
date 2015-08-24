public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curr = 0;
        int max = Integer.MIN_VALUE;
        for (int val : nums) {
            if (curr < 0) {
                curr = 0;
            }
            curr += val;
            max = Math.max(max, curr);
        }
        return max;
    }
}