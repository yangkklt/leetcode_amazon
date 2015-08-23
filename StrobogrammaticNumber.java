public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        if (num.isEmpty()) {
            return true;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        
        int i = 0;
        int j = num.length() - 1;
        while (i <= j) {
            char a = num.charAt(i);
            char b = num.charAt(j);
            if (!map.containsKey(a) || !map.containsKey(b)) {
                return false;
            }
            if (map.get(a) != b) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}