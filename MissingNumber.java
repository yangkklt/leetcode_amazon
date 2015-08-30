public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res ^= i;
        }
        
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        
        return res;
    }
}