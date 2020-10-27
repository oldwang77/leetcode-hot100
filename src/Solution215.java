import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution215{
    //通过优先队列构建大顶堆
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // java默认是小顶堆
        // 优先队列
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len,(a,b)->(b-a));
        for(int num:nums){
            minHeap.add(num);
        }
        for(int i=0;i<k-1;i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}


// public class Solution215 {
//     public int findKthLargest(int[] nums, int k) {
//         quickSort(nums, 0, nums.length - 1);
//         return nums[nums.length - k];
//     }
//
//     public void quickSort(int[] nums, int l, int r) {
//         // 递归结束的条件
//         if (l >= r) return;
//         // 分界点
//         int ans = nums[l];
//
//         // 两个边界
//         int i = l - 1;
//         int j = r + 1;
//         while (i < j) {
//             do i++; while (nums[i] < ans);
//             do j--; while (nums[j] > ans);
//             if(i<j){
//                 int tmp = nums[i];
//                 nums[i] = nums[j];
//                 nums[j] = tmp;
//             }
//         }
//         quickSort(nums, l, j);
//         quickSort(nums, j + 1, r);
//     }
// }
