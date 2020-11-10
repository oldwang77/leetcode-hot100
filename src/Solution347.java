import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution347 {
    // 写的要优雅
    // 建堆的时间复杂度o(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // 重写heap的加入原则
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        // 加入元素到堆中
        for (Integer key : hashMap.keySet()) {
            Integer value = hashMap.get(key);
            // 堆顶元素的数量小于当前元素
            if (heap.size() < k) {
                heap.add(new int[]{key, value});
            } else if (heap.size() == k) {
                if (heap.peek()[1] < value) {
                    heap.poll();
                    heap.add(new int[]{key, value});
                }
            }
        }
        // 取出heap中的元素
        int[] ans = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            ans[index++] = heap.poll()[0];
        }
        return ans;
    }


    // // 建堆的时间复杂度o(n)
    // public int[] topKFrequent(int[] nums, int k) {
    //     HashMap<Integer, Integer> hashMap = new HashMap<>();
    //     for (int num : nums) {
    //         if (hashMap.containsKey(num)) {
    //             hashMap.put(num, hashMap.get(num) + 1);
    //         } else {
    //             hashMap.put(num, 1);
    //         }
    //     }
    //     // 维护一个小顶堆
    //     PriorityQueue<Integer> heap = new PriorityQueue<>(k);
    //     //PriorityQueue<Integer> heap = new PriorityQueue<>(k,(a,b)->(b-a));
    //     for (int i = 0; i < nums.length; i++) {
    //         if (heap.contains(nums[i])) {
    //             continue;
    //         }
    //         if (heap.size() < k) {
    //             heap.add(nums[i]);
    //         } else {
    //             int topNode = heap.peek();
    //             if (hashMap.get(topNode) < hashMap.get(nums[i])) {
    //                 heap.poll();
    //                 heap.add(nums[i]);
    //             }
    //         }
    //     }
    //     // 最小堆的数据取出返回
    //     int index = 0;
    //     int[] ans = new int[k];
    //     while (!heap.isEmpty()) {
    //         ans[index++] = heap.poll();
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        Solution347 s = new Solution347();
        int[] a = {4, 1, -1, 2, -1, 2, 3};
        s.topKFrequent(a, 2);
    }
}
