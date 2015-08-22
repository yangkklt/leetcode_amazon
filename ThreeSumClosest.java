public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = target + Integer.MAX_VALUE;
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(nums[i] + nums[left] + nums[right] - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum == target) {
                    return res;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;        
    }
}