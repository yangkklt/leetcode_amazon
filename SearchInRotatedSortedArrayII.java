public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return true;
        }
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[start] == target || nums[mid] == target || nums[end] == target) {
                return true;
            }
            if (nums[start] < nums[mid]) {
                if (nums[start] < target && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target < nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                start++;
            }
        }
        return nums[start] == target || nums[end] == target;
    }
}