package com.imooc.concurrency.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 *
 * @author Daniel Liu 2020/1/1 19:31
 */
@Slf4j
public class LockExample2 {
    class Data {
    }

    private final Map<String, Data> treeMap = new TreeMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    //可以直接Ctrl+Alt+T调用快捷键，不必定义读写锁，
/*
    //获得读写锁中的读锁
    private final Lock readLock = lock.readLock();

    //获得读写锁中的写锁
    private final Lock writeLock = lock.writeLock();
*/

    /**
     * 获取data,读锁
     *
     * @param key
     * @return
     */
    public Data getData(String key) {
        lock.readLock().lock();
        try {
            return treeMap.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * 获取所有key,读锁
     *
     * @return
     */
    public Set<String> getAllKeys() {
        lock.readLock().lock();
        try {
            return treeMap.keySet();
        } finally {
            lock.readLock().unlock();
        }

    }

    /**
     * 写锁
     *
     * @param key
     * @param value
     * @return
     */
    public Data put(String key, Data value) {
        //可能导致线程饥饿，处于一直等待状态
        lock.writeLock().lock();
        try {
            return treeMap.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }
}