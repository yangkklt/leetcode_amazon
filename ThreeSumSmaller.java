public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;       
    }
}
