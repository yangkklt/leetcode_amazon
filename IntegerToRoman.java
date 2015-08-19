public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] intSymbol = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] stringSymbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            if (intSymbol[i] <= num) {
                num -= intSymbol[i];
                builder.append(stringSymbol[i]);
            } else {
                i++;
            }
        }
        return builder.toString();
    }
}