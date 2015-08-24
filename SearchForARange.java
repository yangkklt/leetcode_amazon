public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
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
        if (nums[end] == target) {
            res[0] = end;
        }
        if (nums[start] == target) {
            res[0] = start;
        }
        if (res[0] == -1) {
            return res;
        }

        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            res[1] = start;
        }
        if (nums[end] == target) {
            res[1] = end;
        }
        return res;
    }
}