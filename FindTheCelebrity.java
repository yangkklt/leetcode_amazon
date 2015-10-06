/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        boolean[] hasVisited = new boolean[n];
        Arrays.fill(hasVisited, false);
        boolean isPopularity = true;
        while (!queue.isEmpty()) {
            int candidate = queue.poll();
            if (hasVisited[candidate]) {
                continue;
            }
            isPopularity = true;
            for (int i = 0; i < n; i++) {
                if (i == candidate) {
                    continue;
                }
                if (knows(candidate, i) && knows(i, candidate)) {
                    isPopularity = false;
                } else if (knows(candidate, i) && !knows(i, candidate)) {
                    isPopularity = false;
                    queue.offer(i);
                } else if (!knows(candidate, i) && !knows(i, candidate)) {
                    isPopularity = false;                    
                }
            }
            hasVisited[candidate] = true;
            if (isPopularity) {
                return candidate;
            }
        }
        
        return -1;
    }
}