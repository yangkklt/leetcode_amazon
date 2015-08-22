public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start]) {
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }
}