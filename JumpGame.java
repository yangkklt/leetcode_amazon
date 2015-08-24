public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int boundary = nums[0];
        int curr = 0;
        int n = nums.length;
        while (curr <= Math.min(n, boundary)) {
            boundary = Math.max(boundary, curr + nums[curr]);
            if (boundary >= n - 1) {
                return true;
            }
            curr++;
        }
        return false;
    }
}