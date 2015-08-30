public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[start] < nums[mid] && nums[mid] < nums[end]) {
                return nums[start];
            }
            if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}