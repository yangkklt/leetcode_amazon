public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(res, curr, nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int index) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}