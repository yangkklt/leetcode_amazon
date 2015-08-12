public class AddBinary {
    public String addBinary(String a, String b) {
        if (a.isEmpty() && b.isEmpty()) {
            return "";
        }
        if (a.isEmpty() || b.isEmpty()) {
            return a.isEmpty() ? b : a;
        }
        
        StringBuffer res = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int next = 0;
        
        for (; i >= 0 && j >= 0; i--, j--) {
            int c = Character.getNumericValue(a.charAt(i));
            int d = Character.getNumericValue(b.charAt(j));
            res.append((c + d + next) % 2);
            next = (c + d + next) / 2;
        }
        for (; i >= 0; i--) {
            int c = Character.getNumericValue(a.charAt(i));
            res.append((c + next) % 2);
            next = (c + next) / 2;
        }
        
        for (; j >= 0; j--) {
            int c = Character.getNumericValue(b.charAt(j));
            res.append((c + next) % 2);
            next = (c + next) / 2;
        }
        
        if (next != 0) {
            res.append(next);
        }
        
        return res.reverse().toString();
    }
}