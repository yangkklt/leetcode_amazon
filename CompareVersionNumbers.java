public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        int length = Math.min(strs1.length, strs2.length);
        
        for (int i = 0; i < length; i++) {
            int a = Integer.parseInt(strs1[i]);
            int b = Integer.parseInt(strs2[i]);
            int res = compareNumber(a, b);
            if (res != 0) {
                return res;
            }
        }
        
        for (int i = length; i < strs1.length; i++) {
            int a = Integer.parseInt(strs1[i]);
            int res = compareNumber(a, 0);
            if (res != 0) {
                return res;
            }
        }
 
        for (int i = length; i < strs2.length; i++) {
            int a = Integer.parseInt(strs2[i]);
            int res = compareNumber(0, a);
            if (res != 0) {
                return res;
            }
        } 
        
        return 0;
    }
    
    private int compareNumber(int a, int b) {
        if (a > b) {
            return 1;
        } else if (a < b) {
            return -1;
        } else {
            return 0;
        }
    }
}