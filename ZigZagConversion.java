public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        if (numRows >= s.length() || numRows == 1) {
            return s;
        }
        
        StringBuilder builder = new StringBuilder();
        int delta = 2 * (numRows - 1);
        
        for (int i = 0; i * delta < s.length(); i++) {
            builder.append(s.charAt(i * delta));
        }
        
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; j * delta <= s.length(); j++) {
                if (i + j * delta < s.length()) {
                    builder.append(s.charAt(i + j * delta));
                }
                if (j * delta + delta - i < s.length()) {
                    builder.append(s.charAt(j * delta + delta - i));
                }
            }
        }
        
        for (int i = 0; i * delta + numRows <= s.length(); i++) {
            builder.append(s.charAt(i * delta + numRows - 1));
        }
        
        return builder.toString();
    }
}