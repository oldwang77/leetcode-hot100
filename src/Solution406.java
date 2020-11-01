import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution406 {
    /**
     * 主要是要理解，为什么按高到矮然后按K升序排序，然后相对矮的插入对应的k位置？
     * 矮的人相对于高的人是看不见的：因为k的值是前面比自己高或等高的人的个数。先处理高的人，满足k的条件后，再处理矮的人是不会破坏这个条件的。
     * 相对矮的人插入对应的k位置的话，可以保证结果中的k条件不被破坏（因为此时结果中高的人已经站好了，矮的无法影响他们），
     * 但是因为矮的人要占据一个位置的，所以后面的人只能往后面挪动。
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        if (len == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] < b[1] ? -1 : 1;
                } else {
                    return a[0] > b[0] ? -1 : 1;
                }
            }
        });
        // 将小的数查到合适的位置里
        List<int[]> ans = new ArrayList<>();
        ans.add(people[0]);
        for (int i = 1; i < len; i++) {
            ans.add(people[i][1], people[i]);
        }
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution406 s = new Solution406();
        int[][] a = {{7,0},{4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        s.reconstructQueue(a);
    }
}
