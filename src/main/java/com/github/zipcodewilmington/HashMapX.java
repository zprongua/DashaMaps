package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public interface HashMapX {
    // fundamentals
    void set(Object key, Object value);
    Object delete(Object key);
    Object get(Object key);
    boolean isEmpty();
    long size();

    // testing access
    boolean bucketSize(Object key); // used for tests
}
