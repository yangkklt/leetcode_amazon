public class DecodeWays {
    public int numDecodings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        int one = s.charAt(0) == '0' ? 0 : 1;
        int two = 1;
        
        for (int i = 1; i < s.length(); i++) {
            int value = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
            if (s.charAt(i) == '0') {
                one = 0;
            }
            if (value < 10 || value > 26) {
                two = 0;
            }
            int temp = one;
            one += two;
            two = temp;
        }
        
        return one;
    }
}