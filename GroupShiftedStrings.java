public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            List<String> curr = new ArrayList<String>();
            String key = getPattern(str);
            if (map.containsKey(key)) {
                curr = map.get(key);
            } else {
                curr = new ArrayList<String>();
            }
            curr.add(str);
            map.put(key, curr);
        }
        
        for (List<String> value : map.values()) {
            Collections.sort(value);
            res.add(value);
        }
        
        return res;
    }
    
    private String getPattern(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            builder.append((str.charAt(i) - str.charAt(i - 1) + 26) % 26).append("#");;
        }
        return builder.toString();
    }
}