package com.github.zipcodewilmington;

public class KVdata<T extends Comparable<T>> implements Comparable<KVdata<T>> {
    private String k;
    private Integer v;

    public KVdata(String key, Integer value) {
        this.k = key;
        this.v = value;
    }

    public KVdata(String key) {
        this.k = key;
        this.v = null;
    }

    public String getKey() {
        return k;
    }

    public Integer getValue() {
        return v;
    }

    public void setKey(String key) {
        this.k = key;
    }

    public void setValue(Integer value) {
        this.v = value;
    }

    @Override
    public int compareTo(KVdata<T> o) {
        if (this.k.equals(o.getKey())) return 0;
        else return -1;
    }
}
