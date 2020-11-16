import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/
public class Solution338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                ans[i] = ans[i - 1] + 1;
            } else {
                ans[i] = ans[i / 2];
            }
        }
        return ans;
    }
}
