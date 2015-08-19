public class CountAndSay {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = getNext(res);
        }
        return res;
    }
    
    private String getNext(String str) {
        StringBuilder builder = new StringBuilder();
        int begin = 0;
        int end = 0;
        while (end < str.length()) {
            while (end < str.length() && str.charAt(begin) == str.charAt(end)) {
                end++;
            }
            builder.append(end - begin).append(str.charAt(begin));
            begin = end;
        }
        
        return builder.toString();
    }
}