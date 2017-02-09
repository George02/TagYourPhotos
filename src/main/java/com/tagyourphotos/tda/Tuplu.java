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
public class Tuplu<K,V> {
    private final K item1;
    private final V item2;
    
    public Tuplu(K item1, V item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public K getItem1() {
        return item1;
    }

    public V getItem2() {
        return item2;
    }
}
