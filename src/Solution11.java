public class Solution11 {
    // 双指针问题
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        int maxx = 0;
        while (l <= r) {
            if (height[l] <= height[r]) {
                ans = height[l] * (r - l);
                l++;
            } else {
                ans = height[r] * (r - l);
                r--;
            }
            maxx = Math.max(ans, maxx);
        }
        return maxx;
    }
}
