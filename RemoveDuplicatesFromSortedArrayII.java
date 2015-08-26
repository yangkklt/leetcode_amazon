public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[index - 2] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}