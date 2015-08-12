public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        
        str = str.trim();
        
        if (str.isEmpty()) {
            return 0;
        }
        
        int sign = 1;
        int index = 0;

        if (str.charAt(0) == '+') {
            index++;
        } else if (str.charAt(0) == '-') {
            index++;
            sign = -1;
        }
        
        long res = 0;
        for (; index < str.length(); index++) {
            char c = str.charAt(index);
            if (!Character.isDigit(c)) {
                break;
            }
            res = res * 10 + Character.getNumericValue(c);
            if (res > Integer.MAX_VALUE) {
                break;
            }
        }
        
        if (res > Integer.MAX_VALUE) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        return (int) res * sign;
    }
}