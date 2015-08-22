public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s.isEmpty() || s.length() < 2 || s.length() > 12) {
            return res;
        }
        List<String> curr = new ArrayList<String>();
        helper(res, curr, s);
        return res;
    }
    
    private void helper(List<String> res, List<String> curr, String s) {
        if (curr.size() > 4 || (s.length() > (4 - curr.size()) * 3) || s.length() < (4 - curr.size())) {
            return;
        }
        if (curr.size() == 4) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                builder.append(curr.get(i)).append(".");
            }
            builder.append(curr.get(3));
            res.add(builder.toString());
            return;
        }
        
        for (int i = 0; i < Math.min(3, s.length()); i++) {
            if (isValid(s.substring(0, i + 1))) {
                curr.add(s.substring(0, i + 1));
                helper(res, curr, s.substring(i + 1));
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        int value = Integer.parseInt(s);
        // 00
        if (value == 0 && s.length() > 1) {
            return false;
        }
        
        // 010
        if (value != 0 && s.charAt(0) == '0') {
            return false;
        }
        if (value > 255) {
            return false;
        }
        return true;
    }
}