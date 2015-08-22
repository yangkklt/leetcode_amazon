public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(res, "", n, n);
        return res;
    }
    
    private void helper(List<String> res, String curr, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(curr);
            return;
        }
        if (left > right || left < 0 || right < 0) {
            return;
        }
        helper(res, curr + "(", left - 1, right);
        helper(res, curr + ")", left, right - 1);
    }
}