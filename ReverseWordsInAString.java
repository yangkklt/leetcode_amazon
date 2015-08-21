public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        if (s == null || s.isEmpty()) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        int end = s.length() - 1;
        int start = s.length() - 1;
        while (start >= 0) {
            if (s.charAt(start) != ' ') {
                start--;
            } else {
                builder.append(s.substring(start + 1, end + 1));
                while (start >= 0 && s.charAt(start) == ' ') {
                    start--;
                }
                end = start;
                builder.append(" ");
            }
        }
        builder.append(s.substring(0, end + 1));
        return builder.toString();
    }

}