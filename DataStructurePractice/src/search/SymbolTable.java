package search;

import java.util.Iterator;

/*符号表:也称为字典
* 最主要的目的就是将一个键和一个值联系起来
* 符号表是一种存储键值对的数据结构，支持两种操作：
* 1.插入put:即将一组新的键值对存入表中
* 2.查找get:即根据给定的键得到相应的值*/
public class SymbolTable<Key extends Comparable<Key>, Value>{
    public SymbolTable() {

    }

    public void put(Key key, Value value) {

    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return 1;
    }
//
//    public Key min() {
//
//    }
//
//    public Key max() {
//
//    }
//
//    public Key floor(Key key) {
//
//    }
//
//    public Key ceilling(Key key) {
//
//    }
//
//    public int rank(Key key) {
//
//    }
//
//    public Key select(int k) {
//
//    }
//
//    public void deleteMin() {
//        delete(min());
//    }
//
//    public void deleteMax() {
//        delete(max());
//    }
//
//    public int size(Key low, Key high) {
//        if (high.compareTo(low) < 0) {
//            return 0;
//        } else if (contains(high)) {
//            return rank(high) - rank(low) + 1;
//        }else{
//            return rank(high) - rank(low);
//        }
//    }
//
//    public Iterable<Key> keys(Key low, Key high) {
//
//    }
//
//    public Iterable<Key> keys() {
//        return keys(min(), max());
//    }
}
