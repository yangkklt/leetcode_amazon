public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(res, curr, 0, 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int sum, int index, int k, int n) {
        if (sum == n) {
            if (curr.size() == k) {
                res.add(new ArrayList<Integer>(curr));
            }
            return;
        }
        
        if (index == 10 || sum > n || curr.size() > k) {
            return;
        }
        for (int i = index; i < 10; i++) {
            if (sum + index > n) {
                return;
            }
            curr.add(i);
            helper(res, curr, sum + i, i + 1, k, n);
            curr.remove(curr.size() - 1);
        }
    }
}