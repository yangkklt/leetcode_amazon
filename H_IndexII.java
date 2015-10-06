public class H_IndexII {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            return citations[0] >= 1 ? 1 : 0;
        }
        int n = citations.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (citations[mid] < n - mid) {
                start = mid;
            } else if (citations[mid] >= n - mid) {
                end = mid;
            }
        }

        if (citations[start] >= n - start) {
            return n - start;
        }
                if (citations[end] >= n - end) {
            return n - end;
        }
        return 0;
    }
}