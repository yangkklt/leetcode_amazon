public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        rotateHelper(nums, 0, nums.length - 1);
        rotateHelper(nums, 0, k % nums.length - 1);
        rotateHelper(nums, k % nums.length, nums.length - 1);
    }
    
    private void rotateHelper(int[] nums, int a, int b) {
        while (a < b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
        }
    }
}