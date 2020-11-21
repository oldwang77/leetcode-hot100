import java.util.Arrays;
import java.util.HashMap;

public class Solution621 {
    // https://leetcode-cn.com/problems/task-scheduler/solution/ren-wu-diao-du-qi-by-leetcode/
    // 时间片分配
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int time = 0;
        if (len == 1) {
            return 1;
        }

        //每个字符出现的次数
        int[] map = new int[26];
        for (char ch : tasks) {
            int ans = ch - 'A';
            map[ans]++;
        }
        Arrays.sort(map);
        // n+1个数字为一组
        // map[25]表示这个任务中出现最多次数的任务
        while (map[25] > 0) {
            int cnt = 0;
            // n+1个任务是一组
            while (cnt <= n) {
                // map[25]表示这个任务中出现最多次数的任务数量为0时，任务结束了
                if (map[25] == 0) {
                    break;
                }
                if (cnt <26 && map[25 - cnt] > 0) {
                    map[25 - cnt]--;
                }
                time++;
                cnt++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}
