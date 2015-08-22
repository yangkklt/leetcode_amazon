public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for (int j = 2; j < i; j++) {
                curr.add(res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1));
            }
            if (i != 1) {
                curr.add(1);
            }
            res.add(curr);
        }
        return res;
    }
}