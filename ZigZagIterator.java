import java.util.NoSuchElementException;
public class ZigzagIterator {
    private final Iterator<Integer> iterator1;
    private final Iterator<Integer> iterator2;
    private int index;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterator1 = v1.iterator();
        iterator2 = v2.iterator();
        index = 0;
    }

    public int next() {
        int res = 0;
        if (index % 2 == 0) {
            if (iterator1.hasNext()) {
                res = iterator1.next();
            } else if (iterator2.hasNext()) {
                res = iterator2.next();
            } else {
                throw new NoSuchElementException("No Such Element.");
            }
        } else {
            if (iterator2.hasNext()) {
                res = iterator2.next();
            } else if (iterator1.hasNext()) {
                res = iterator1.next();
            } else {
                throw new NoSuchElementException("No Such Element.");
            }
        }
        index++;
        return res;
    }

    public boolean hasNext() {
        return iterator1.hasNext() || iterator2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */