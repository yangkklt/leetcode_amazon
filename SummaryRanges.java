public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums.length == 0) {
            return res;
        }
        Range range = new Range(nums[0], nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - range.end == 1) {
                range.end = nums[i];
            } else {
                res.add(convert(range));
                range = new Range(nums[i], nums[i]);
            }
        }
        
        res.add(convert(range));
        return res;
    }
    
    private String convert(Range range) {
        StringBuilder builder = new StringBuilder();
        if (range.start == range.end) {
            builder.append(range.start);
        } else {
            builder.append(range.start).append("->").append(range.end);
        }
        return builder.toString();
    }
    class Range {
        public int start;
        public int end;
        public Range(int s, int e) {
            start = s;
            end = e;
        }
    }
}