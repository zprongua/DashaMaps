package com.github.zipcodewilmington;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMap {
    public SLL[] hashArray = new SLL[26];

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
            KVdata found = (KVdata) hashArray[idx].get(foundidx);
            return found.getValue();
        }
        return -1;
    }

    public boolean isEmpty() {
        int sum = 0;
        for (SLL tl : hashArray) {
            if (tl != null) {
                sum += 1;
            }
        }
        return sum <= 0;
    }

    public Integer size() {
        int sum = 0;
        for (SLL tl : hashArray) {
            if (tl != null) {
                sum += tl.size();
            }
        }
        return sum;
    }

    public int bucketSize(String key) {
        if (hashArray[keyToIndex(key)] != null) {
            return hashArray[keyToIndex(key)].size();
        }
        return 0;
    }

    public void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("word-list.txt"))) {
            SLL sll = new SLL<>();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String key = parts[0];
                int value = Integer.parseInt(parts[1]);
                this.set(key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
