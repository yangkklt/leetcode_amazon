public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (target < nums[start]) {
            return start;
        } else if (target == nums[start]) {
            return start;
        } else if (target > nums[start] && target <= nums[end]) {
            return end;
        } else {
            return end + 1;
        }
    }
}