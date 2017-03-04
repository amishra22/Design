package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Abhinav on 03-03-2017.
 */
public class MyMap <K,V> {

    static class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;
        Entry<K,V> prev;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private List<Entry<K,V>> table;

    public MyMap(int capacity) {
        table = new ArrayList<Entry<K, V>>();
        for(int i=0; i<capacity; i++) {
            table.add(null);
        }
    }

    public void put(K key, V value) {
        Entry<K, V> node = getNodeForKey(key);
        // if node already exists .. update the value
        if(node != null) {
            node.value = value;
            return;
        }

        node = new Entry<>(key, value);
        int index = getIndexForKey(key);

        if(table.get(index) != null) {
            node.next = table.get(index);
            node.next.prev = node;
        }
        table.set(index, node);

    }


    public V get(K key) {
        Entry<K, V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }

    public void remove(K key) {
        Entry<K, V> node = getNodeForKey(key);
        // if node exist
        if(node != null) {

            // if it is not the head node
            if(node.prev != null) {
                node.prev.next = node.next;
            } else {
                // removing head node
                int hashKey = getIndexForKey(key);
                table.set(hashKey, node.next);
            }

            // setting the next node's prev pointer if it  was not the last
            if(node.next != null) {
                node.next.prev = node.prev;
            }
        }

    }

    private Entry<K, V> getNodeForKey(K key) {
        int index = getIndexForKey(key);
        Entry<K, V> node = table.get(index);
        while(node != null) {
            if(node.key == key) {
                return node;
            }
            node = node.next;
        }
        return  null;
    }

    private int getIndexForKey(K key) {
        return Math.abs(key.hashCode() % table.size());
    }

    public void printMap(){

        for(int i=0; i<table.size(); i++) {
            Entry<K, V> iterator = table.get(i);
            System.out.print("{ ");
            while(iterator != null){
                System.out.print("(" + iterator.key + "-" + iterator.value + "), ");
                iterator = iterator.next;
            }
            System.out.println(" }");
        }
    }
}
