import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 拓扑排序
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        // 统计每个结点的入度信息
        for(int[] cp:prerequisites){
            in[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        // 结点度数为0的结点入队
        for(int i=0;i<numCourses;i++){
            if(in[i]==0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int ans = que.poll();
            numCourses--;
            in[ans] = -1;
            // 和ans指向的所有结点的度-1
            // -1操作完成后，这个结点指向的结点如果度数为0，那么入队
            for(int x:adj.get(ans)){
                in[x]--;
                if(in[x]==0){
                    que.add(x);
                }
            }
        }

        return numCourses==0;
    }
}
