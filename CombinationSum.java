public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return res;
        } 
        Arrays.sort(candidates);
        List<Integer> curr = new ArrayList<Integer>();
        helper(res, curr, candidates, 0, 0, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int index, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if (index == candidates.length || sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                return;
            }
            curr.add(candidates[i]);
            helper(res, curr, candidates, i, sum + candidates[i], target);
            curr.remove(curr.size() - 1);
        }
    }
}