public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs.length == 0) {
            return res;
        }
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < strs.length; i++) {
            String key = getSortedString(strs[i]);
            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> value = new ArrayList<Integer>();
                value.add(i);
                map.put(key, value);
            }
        }
        
        for (String key : map.keySet()) {
            List<String> str = new ArrayList<String>();
            List<Integer> curr = map.get(key);
            for (int i = 0; i < curr.size(); i++) {
                String element = strs[curr.get(i)];
                str.add(element);
            }
            Collections.sort(str);
            res.add(str);
        }
        
        return res;
    }
    
    private String getSortedString(String str) {
        char[] array = str.toCharArray();
        Arrays.sort(array);
        return String.valueOf(array);
    }
}