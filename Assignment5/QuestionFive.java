package Assignment5;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The task is to design and implement methods of an LRU cache. The class has two methods get and set which are defined as follows.
 * get(x)   : Gets the value of the key x if the key exists in the cache otherwise returns -1
 * set(x,y) : inserts the value if the key x is not already present. If the cache reaches its capacity it should invalidate the least recently used item before inserting the new item.
 * In the constructor of the class the size of the cache should be initialized.
 */
public class QuestionFive {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public QuestionFive(int capacity)
    {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key)
    {
        System.out.println("Going to get the value " +
                "for the key : " + key);
        return map.getOrDefault(key, -1);
    }

    // This method works in O(1)
    public void set(int key, int value)
    {
        System.out.println("Going to set the (key, " +
                "value) : (" + key + ", " + value + ")");
        map.put(key, value);
    }
}

class TestLRUCacheWithLinkedHashMap {

    public static void main(String[] args)
    {
        System.out.println("Going to test the LRU "+
                " Cache Implementation");
        QuestionFive cache = new QuestionFive(2);

        cache.set(1, 10);

        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns 10

        // evicts key 2 and store a key (3) with
        // value 30 in the cache.
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40

    }
}
