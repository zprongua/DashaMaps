package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap {
    String key;
    Integer value;

    SLL[] hashArray = new SLL[26];

    public DashaMap() {}

    int charToIndex(char ch) { return ch - 'a'; }

    public int keyToIndex(Object s) {
        char ch = 'a';
        if (String.valueOf(s).length() > 0) {
            ch = String.valueOf(s).charAt(0);
        }
        return charToIndex(ch);
    }

    public void set(String key, Integer value) {
        KVdata tkv = new KVdata(key, value);
        int idx = this.keyToIndex(key);
        if (hashArray[idx] == null) {
            hashArray[idx] = new SLL<>();
        }
        hashArray[idx].add(tkv);
    }

    public Integer delete(String key) {
        int idx = this.keyToIndex(key);
        KVdata target = new KVdata(key, 0);
        if (hashArray[idx] == null) {
            return null;
        }
        int foundidx = hashArray[idx].find(target);
        if (foundidx == -1) return null;
        KVdata found = (KVdata) hashArray[idx].get(foundidx);
        if (found.hashCode() == hashArray[idx].get(0).hashCode()) {
            hashArray[idx] = null;
        } else {
            hashArray[idx].remove(foundidx);
        }
        return found.getValue();
    }

    public Integer get(String key) {
        int idx = this.keyToIndex(key);
        KVdata target = new KVdata(key, 0);
        if (hashArray[idx] == null) {
            return null;
        }
        int foundidx = hashArray[idx].find(target);
        if (foundidx != -1) {
            KVdata found = (KVdata) hashArray[idx].get(idx);
            return found.getValue();
        }
        return -1;
    }

    public boolean isEmpty() {
        int sum = 0;
        for (SLL tl : hashArray) {
            if (tl != null) {
                return false;
            }
        }
        return true;
    }

    public Integer size() {
        int sum = 0;
        for (SLL tl : hashArray) {
            sum += tl.size();
        }
        return sum;
    }

    public int bucketSize(String key) {
        return hashArray[keyToIndex(key)].size();
    }
}
