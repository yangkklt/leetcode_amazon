public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits.isEmpty()) {
            return res;
        }
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<String>();
        queue.offer("");
        for (int i = 0; i < digits.length(); i++) {
            String curr = dict[digits.charAt(i) - '0'];
            if (!curr.equals("")) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String temp = queue.poll();
                    for (int k = 0; k < curr.length(); k++) {
                        queue.offer(temp + curr.charAt(k));
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        
        return res;
    }
}