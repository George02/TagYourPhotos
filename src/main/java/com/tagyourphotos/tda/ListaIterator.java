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
public class ListaIterator<K> implements Iterator<K>{
    
    private int contor = 0;
    private Lista<K> lista;
    
    public ListaIterator(Lista<K> lista){
        this.contor = 0;
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return lista.isDefAt(contor);
    }

    @Override
    public Nod<K> get() {
        Nod<K> next = lista.getElementAt(contor);
        contor++;
        return next;
    }
}
