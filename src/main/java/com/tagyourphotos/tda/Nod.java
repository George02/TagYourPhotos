/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda;

import com.tagyourphotos.tda.abs.TDAListaCell;

/**
 *
 * @author george
 * @param <K> Tipul informatiei continute de celula
 */
public class Nod<K> implements TDAListaCell<K> {

    private K info;
    private Nod<K> next;

    public Nod() {
        this.info = null;
        this.next = null;
    }
    
    public Nod(Nod<K> cell) {
        this.info = cell.info;
        this.next = cell.next;
    }

    public Nod(K info) {
        this.info = info;
        this.next = null;
    }

    public Nod(K info, Nod<K> next) {
        this.info = info;
        this.next = next;
    }

    @Override
    public K getInfo() {
        return info;
    }

    @Override
    public void setInfo(K info) {
        this.info = info;
    }

    @Override
    public Nod<K> getNext() {
        return next;
    }

    @Override
    public void setNext(TDAListaCell<K> next) {
        this.next = (Nod<K>) next;
    }

}
