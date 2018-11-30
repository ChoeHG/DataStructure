package search;
/*散列的查找算法：
* 1.用散列函数将被查找的键转化为数组的一个索引
* 2.处理碰撞冲突：拉链法和线性探测法 */

//基于拉链法的散列表
public class SeparateChainingHashST<Key,Value> {
    private int N;
    private int M;
    private SeparateChainingHashST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        //需要进行类型转换，Java不允许泛型的数组
        st = (SeparateChainingHashST<Key, Value>[]) new SeparateChainingHashST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SeparateChainingHashST();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public Iterable<Key> keys() {
        return null;
    }
}
