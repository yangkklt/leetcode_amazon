public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int[] elements = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] freq = {0, 0, 0};
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int pos = findElement(elements, num);
            if (pos != -1) {
                elements[pos] = num;
                freq[pos]++;
                continue;
            }
            pos = findZeroElement(freq);
            if (pos != -1) {
                elements[pos] = num;
                freq[pos] = 1;
                continue;
            }
            pos = findMinimumFreq(freq);
            freq[pos]--;
            if (freq[pos] == 0) {
                elements[pos] = num;
                freq[pos] = 1;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (freq[i] > nums.length / 3) {
                res.add(elements[i]);
            }
        }
        
        return res;
    }
    
    private int findElement(int[] elements, int num) {
        for (int i = 0; i < 3; i++) {
            if (elements[i] == num) {
                return i;
            }
        }
        return -1;
    }
    private int findZeroElement(int[] freq) {
        for (int i = 0; i < 3; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    
    private int findMinimumFreq(int[] freq) {
        int i = 0;
        if (freq[1] < freq[0]) {
            return 1;
        }
        if (freq[2] < freq[0]) {
            return 2;
        }
        return 0;
    }
}