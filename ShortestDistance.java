public class ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int max = Integer.MAX_VALUE;
        int first = -1;
        int second = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                max = second == -1 ? max : Math.min(max, i - second);
                first = i;
            } else if (words[i].equals(word2)) {
                max = first == -1 ? max : Math.min(max, i - first);
                second = i;
            }
        }
        return max;
    }
}