public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                return res;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}