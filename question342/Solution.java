package question342;

public class Solution {

    public boolean isPowerOfFour(int num) {
        if (0 > num || (num & (num - 1)) != 0) {
            return false;
        }
        return (num & 0x55555555) != 0;
    }

}
