import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class LRUCache {

    int cap;
    HashMap<Integer, Integer> hashMap;
    LinkedList<Integer> lst;

    public LRUCache(int capacity) {
        cap = capacity;
        hashMap = new HashMap<>();
        lst = new LinkedList<>();
    }

    public int get(int key) {
        // 把使用了的这个数据刷新到list中
        Integer ans = key;
        if (lst.contains(ans)) {
            lst.remove(ans);
        } else {
            return -1;
        }
        lst.addFirst(ans);
        return hashMap.get(key);
    }

    public void put(int key, int value) {
        // 删除末尾的key
        if (cap == hashMap.size() && !hashMap.containsKey(key)) {
            Integer ans = lst.removeLast();
            hashMap.remove(ans);
        }
        // 如果不包含这个key，那么就把这个key的动态刷新进去
        if(!hashMap.containsKey(key)){
            lst.addFirst(key);
        }else{
            // 如果包含这个key，那么就提高这个key的优先级
            Integer ans = key;
            lst.remove(ans);
            lst.addFirst(ans);
        }
        hashMap.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */