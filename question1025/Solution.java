package question1025;

/**
 * @author qianyihui
 * @date 2019-06-17
 * <p>
 * 找规律即可。
 * <p>
 * N = 2时，爱丽丝赢。
 * N = 3时，爱丽丝输。
 * N = 4时，只要爱丽丝第一次选择1，那么就相当于N = 3时的情况，只不过此时是鲍勃先开始，所以爱丽丝赢。
 * N = 5时，爱丽丝只能选择1，爱丽丝输。
 * N = 6时，爱丽丝赢。
 * N = 7时，爱丽丝输。
 * N = 8时，爱丽丝赢。
 * N = 9时，如果爱丽丝选1，那么爱丽丝就输。如果爱丽丝选3，显然也是爱丽丝输。
 * ……
 * 奇数乘以奇数才能是奇数，如果N是奇数，显然其因数也是奇数，那么差值就是一个偶数，而偶数时先手赢，因此爱丽丝会输。
 * <p>
 * 如果N是偶数，那么，只需要爱丽丝选择1即可，N - 1是一个奇数，而奇数时先手输，因此，爱丽丝会赢。
 * <p>
 * 用位运算提高速度。
 * <p>
 * 时间复杂度和空间复杂度均是O(1)。
 * <p>
 * 执行用时：0ms，击败100%。消耗内存：33.3MB，击败100%。
 */
public class Solution {

    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }

}
