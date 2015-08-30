public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int max = Integer.MAX_VALUE;
        int first = -1;
        int second = -1;
        boolean areEquals = word1.equals(word2);
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) && (!areEquals || (areEquals && count % 2 == 0))) {
                max = second == -1 ? max : Math.min(max, i - second);
                first = i;
                count++;
            } else if (words[i].equals(word2) && (!areEquals || (areEquals && count % 2 != 0))) {
                max = first == -1 ? max : Math.min(max, i - first);
                second = i;
                count++;
            }
        }
        return max;
    }
}