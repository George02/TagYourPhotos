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
public interface TDAListaCell<K> {
    K getInfo();
    void setInfo(K info);
    TDAListaCell<K> getNext();
    void setNext(TDAListaCell<K> next);
}
