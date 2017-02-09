/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda;

/**
 *
 * @author george
 */
public class Dictionar<K, V> {

    Lista<Tuplu<K, V>> dictionar;

    public Dictionar() {
        dictionar = new Lista<>();
    }

    public void add(K key, V value) {
        dictionar.append(new Tuplu<>(key, value));
    }

    public boolean containsKey(K key) {
        Iterator<Tuplu<K, V>> iterator = dictionar.getIterator();
        while (iterator.hasNext()) {
            Tuplu<K, V> item = iterator.get().getInfo();
            if (item.getItem1().equals(key)) {
                return true;
            }
        }

        return false;
    }

    public V getValue(K key) {
        Iterator<Tuplu<K, V>> iterator = dictionar.getIterator();
        while (iterator.hasNext()) {
            Tuplu<K, V> item = iterator.get().getInfo();
            if (item.getItem1().equals(key)) {
                return item.getItem2();
            }
        }

        return null;
    }

    public Lista<K> getKeysSet() {
        Lista<K> keys = new Lista<>();
        Iterator<Tuplu<K, V>> iterator = dictionar.getIterator();
        while(iterator.hasNext()){
            keys.append(iterator.get().getInfo().getItem1());
        }
        
        return keys;
    }
}
