public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() > t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1, s.length()).equals(t.substring(i + 1, t.length()));
                } else {
                    return s.substring(i, s.length()).equals(t.substring(i + 1, t.length()));
                }
            }
        }
        
        return s.length() != t.length();
    }
}