package com.company.dao;

import java.util.List;

public interface DAO<K,V> {

    void update(V value, K key);
    void delete(K key);
    V getByKey(K key);
    void addElement(V value);
    List<V> selectAll();
}
