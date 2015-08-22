public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int time = 1;
        for (int i = 1; i < nums.length; i++) {
            int element = nums[i];
            if (element != res) {
                time--;
                if (time == 0) {
                    res = element;
                    time = 1;
                }
            } else {
                time++;
            }
        }
        return res;
    }
}