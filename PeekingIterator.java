// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {
    private Integer peek;
    private final Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!hasNext()) {
            throw new NoSuchElementException("No Element left");
        }
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (!hasNext()) {
	        throw new NoSuchElementException("No Element left");
	    }
	    Integer res = peek;
	    peek = null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    if (peek != null) {
	        return true;
	    }
	    if (iterator.hasNext()) {
	        peek = iterator.next();
	    }
	    return peek != null;
	}
}