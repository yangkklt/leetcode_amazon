public class IsomophicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> first = new HashMap<Character, Character>();
        Map<Character, Character> second = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!first.containsKey(a) && !second.containsKey(b)) {
                first.put(a, b);
                second.put(b, a);
            } else {
                if (first.containsKey(a)) {
                    if (b != first.get(a)) {
                        return false;
                    }
                } else {
                    if (a != second.get(b)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}