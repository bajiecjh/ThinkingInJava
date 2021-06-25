package com.example.hashtable;

import java.util.Map;

/**
 * bajie on 2021/6/24 18:13
 */
public class HashTable<K, V> {

    private static String TAG = "HashTable::";
    // 散列表初始容量
    private static final int INIT_CAPACITY = 8;
    // 装载因子
    private static final float LOAD_FACTOR = 0.75f;
    // 散列表使用的索引数量
    private int tableUse = 0;

    Entry<K, V>[] table;

    public HashTable() {
        table = new Entry[INIT_CAPACITY];
    }


    public void put(K key, V value) {
        int index = hash(key);
        // 如果该索引下没有数据的话，先创建头部哨兵
        if(table[index] == null) {
            table[index] = new Entry<>(null, null, null);
        }

        Entry temp = table[index];
        // 如果index下没有数据，直接插入
        if(temp.next == null) {
            temp.next = new Entry<>(key, value, null);
            tableUse ++;
            // 如果装载因子过高，进行扩容
            if(tableUse >= table.length * LOAD_FACTOR) {
                resize();
            }
        }
        // 使用链表法解决散列冲突
        else {
            while (temp != null) {
                // 说明散列表中已报错该key的值，覆盖value
                if(temp.key == key) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }
            // 在链表头部加入该结点
            Entry headNext = table[index].next;
            table[index].next = new Entry<>(key, value, headNext);
        }
    }

    /**
     * 扩容函数
     */
    private void resize() {
        Entry[] oldTable = table;
        table = new Entry[table.length * 2];
        tableUse = 0;
        // 遍历oldTable
        for(int i = 0; i < oldTable.length; i ++) {
            // 判断是否为空结点
            if(oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }
            // 不是为空结点的话，遍历链表，重新插入table中
            Entry temp = oldTable[i].next;
            while (temp != null) {
                int index = hash(temp.key);
                if(table[index] == null) {
                    table[index] = new Entry<>(null, null, null);
                    tableUse ++;
                }
                Entry temp1 = table[index].next;
                table[index].next = new Entry(temp.key, temp.value, temp1);
                temp = temp.next;
            }
        }
    }

    public void remove(K key) {
        int index = hash(key);
        if(table[index] == null || table[index].next == null) {
            // 散列表中不包含该key的值
            System.out.println("散列表中不包含该key的值");
            return;
        }
        // 遍历散列表的链表
        Entry temp = table[index].next;
        Entry pre = table[index];
        while (temp != null) {
            // 如果key相同，把pre的next指向temp的next
            if(temp.key == key) {
                pre.next = temp.next;
                if(table[index].next == null) tableUse --;
                return;
            }
            pre = pre.next;
            temp = temp.next;
        }
    }

    public V get(K key) {
        int index = hash(key);
        if(table[index] == null || table[index].next == null) {
            return null;
        }
        Entry temp = table[index];
        while (temp.next != null) {
            temp = temp.next;
            if(temp.key == key) {
                return (V) temp.value;
            }
        }
        return null;
    }


    /**
     * 散列函数，参考hashmap的散列函数
     */
    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) % table.length;
    }

    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void test() {
        HashTable hashTable = new HashTable();
        hashTable.put("bajie", "bajie0");
        hashTable.put(1, "bajie1");
        hashTable.put(3, "bajie2");
        hashTable.put(5, "bajie3");
        hashTable.put(5, "bajierecovery");
        hashTable.put(7, "bajie4");
        hashTable.put(0, "bajie5");
        hashTable.put(8, "bajie6");
        hashTable.put(9, "bajie7");
        hashTable.put(2, "bajie7");
        System.out.println(TAG + "get5::"+hashTable.get(5));
        System.out.println(TAG + "remove5::");
        hashTable.remove(5);
        System.out.println(TAG + "get5::"+hashTable.get(5));
    }

}
