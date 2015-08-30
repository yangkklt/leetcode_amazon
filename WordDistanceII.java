public class WordDistanceII {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = init(words);
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int a : list1) {
            for (int b : list2) {
                res = Math.min(res, Math.abs(b - a));
            }
        }
        return res;
    }
    
    private Map<String, List<Integer>> init(String[] words) {
        Map<String, List<Integer>> res = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> list;
            if (res.containsKey(word)) {
                list = res.get(word);
            } else {
                list = new ArrayList<Integer>();
            }
            list.add(i);
            res.put(word, list);
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");