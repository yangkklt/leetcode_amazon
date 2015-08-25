public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zero = 0;
        int two = n - 1;
        int index = 0;
        
        while (index <= two) {
            if (nums[index] == 0) {
                swap(nums, zero++, index++);
            } else if (nums[index] == 2) {
                swap(nums, index, two--);
            } else {
                index++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}