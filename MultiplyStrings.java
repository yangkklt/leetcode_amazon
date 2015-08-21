public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        Arrays.fill(res, 0);
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                res[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        
        for (int i = m + n - 1; i > 0; i--) {
            res[i - 1] += res[i] / 10;
            res[i] %= 10;
        }
        
        int index = 0;
        while (res[index] == 0) {
            index++;
        }
        StringBuilder builder = new StringBuilder();
        
        while (index < m + n) {
            builder.append(res[index]);
            index++;
        }
        
        return builder.toString();
    }
}