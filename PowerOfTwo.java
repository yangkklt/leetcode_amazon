public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i <= 30; i++) {
            if (1 << i == n) {
                return true;
            }
        }
        return false;
    }
}