public class LargestNumber {
    public String largestNumber(int[] nums) {
        ArrayList<String>[] buckets = (ArrayList<String>[])new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<String>();
        }
        for (int i = 0; i < nums.length; i++) {
            String val = Integer.toString(nums[i]);
            buckets[val.charAt(0) - '0'].add(val);
        }
        
        
        for (int i = 0; i < 10; i++) {
            Collections.sort(buckets[i], new Comparator<String>() {
            public int compare(String a, String b) {
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        });
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < buckets[i].size(); j++) {
                builder.append(buckets[i].get(j));
            }
        }
        String res = builder.toString();
        boolean isZero = true;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') {
                isZero = false;
                break;
            }
        }
        return isZero ? Integer.toString(0) : res;
    }
}