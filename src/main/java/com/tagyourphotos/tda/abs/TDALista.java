/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda.abs;

/**
 *
 * @author george
 */
public interface TDALista<K>{
    void append(K li);
    void addFirst(K li);
    void remFirst();
    void addElmAt(K li, int index);
    //void remElmAt(int index);
    //void remElm(K li);
    
    int length();
    boolean isEmpty();
    boolean isDefAt(int index);
    boolean member(K li);
}
