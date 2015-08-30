public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (mid == 0 || mid == nums.length - 1) {
                break;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid;
            } else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        
        return nums[start] > nums[end] ? start : end;
    }
}