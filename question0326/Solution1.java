package question0326;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qianyihui
 * @date 2019-06-25
 * <p>
 * 将所有3的幂都计算出来先存储在一个HashSet集合里。
 * <p>
 * 时间复杂度和空间复杂度均是O(log(Ingeger.MAX_VALUE))。
 * <p>
 * 执行用时：89ms，击败10.31%。消耗内存：40.7MB，击败3.64%。
 */
public class Solution1 {
    private static Set<Integer> set = new HashSet<>();

    static {
        for (int i = 0; ; i++) {
            double temp = Math.pow(3, i);
            if (temp > Integer.MAX_VALUE) {
                break;
            }
            set.add((int) temp);
        }
    }

    public boolean isPowerOfThree(int n) {
        return set.contains(n);
    }
}
