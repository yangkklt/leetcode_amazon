public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<Integer>();
        helper(res, curr, nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int pos) {
        res.add(new ArrayList<Integer>(curr));
        if (pos == nums.length) {
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            helper(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}