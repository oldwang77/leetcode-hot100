import java.util.ArrayList;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) {
            return intervals;
        }
        // 先按照每个区间的起点升序排列
        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<intervals.length-1-i;j++){
                if(intervals[j][0]>intervals[j+1][0]){
                    int[] t = intervals[j+1];
                    intervals[j+1] = intervals[j];
                    intervals[j] = t;
                }
            }
        }
        // 先把第一个区间放入队列
        List<int[]> lst = new ArrayList<>();
        lst.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            // 当前区间
            int[] ans = intervals[i];
            // 已经存在lst中的当前区间
            int[] ans2 = lst.get(lst.size()-1);
            // 比较当前区间的左端点和存在lst区间的右端点
            if(ans[0]>ans2[1]){
                lst.add(ans);
            }
            else if(ans[0]<=ans2[1] && ans2[1]<=ans[1]){
                lst.remove(lst.size()-1);
                int[] tmp = {ans2[0],ans[1]};
                lst.add(tmp);
            }
        }
        int[][] result = new int[lst.size()][lst.get(0).length];
        for(int i =0;i<lst.size();i++){
            for(int j=0;j<lst.get(0).length;j++){
                result[i][j] = (lst.get(i))[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution56 s = new Solution56();
        int[][] intervals = {{4,5},{1,4},{0,1}};
        s.merge(intervals);
    }
}
