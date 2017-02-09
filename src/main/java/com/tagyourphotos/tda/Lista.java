/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda;

import com.tagyourphotos.tda.abs.TDALista;
import com.tagyourphotos.tda.abs.TDAListaCell;

/**
 *
 * @author george
 * @param <K> Tipul elementelor din lista
 */
//http://unde.ro/cursuri/ASD/ASD3.pdf
public class Lista<K> implements TDALista<K> {

    private Nod<K> first;

    public Lista() {
    }

    public Lista(K first) {
        this.first = new Nod<>(first);
    }

    @Override
    public void addFirst(K li) {
        if (first == null) {
            first = new Nod<K>(li);
        } else {
            Nod<K> beforeFirst = new Nod<K>(li);
            beforeFirst.setNext(first);
            first = beforeFirst;
        }
    }

    @Override
    public void remFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }

    @Override
    public void addElmAt(K li, int index) {
        if (index == 0) {
            addFirst(li);
        }

        int contor = 1;
        TDAListaCell<K> prev = null;
        TDAListaCell<K> aux = first;
        do {
            prev = aux;
            if (index == contor) {
                break;
            }

            aux = aux.getNext();
            contor++;
        } while (aux != null);

        if (aux != null) {
            Nod<K> next = new Nod(li);
            next.setNext((Nod<K>) aux.getNext());
            aux.setNext(next);
        } else {
            prev.setNext(new Nod(li));
        }
    }

    @Override
    public int length() {
        if (first == null) {
            return 0;
        }

        int contor = 0;
        Nod<K> aux = first;
        while (aux != null) {
            aux = aux.getNext();
            contor++;
        }

        return contor;
    }

    @Override
    public boolean isEmpty() {
        return this.length() == 0;
    }

    @Override
    public boolean isDefAt(int index) {
        if (first == null) {
            return false;
        }

        int contor = 0;
        Nod<K> aux = first;
        while (aux != null) {
            if (index == contor) {
                return true;
            }
            aux = aux.getNext();
            contor++;
        }

        return false;
    }

    @Override
    public boolean member(K li) {
        if (first == null) {
            return false;
        }

        TDAListaCell<K> aux = first;
        while (aux != null) {
            if (aux.getInfo().equals(li)) {
                return true;
            }

            aux = aux.getNext();
        }

        return false;
    }

    @Override
    public void append(K li) {
        if (first == null) {
            addFirst(li);
        } else {
            TDAListaCell<K> aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            aux.setNext(new Nod(li));
        }
    }

    public Nod<K> getElementAt(int index) {
        if (first == null) {
            return null;
        }

        int contor = 0;
        TDAListaCell<K> aux = first;
        do {
            if (index == contor) {
                return (Nod<K>) aux;
            }
            aux = aux.getNext();
            contor++;
        } while (aux != null);

        return null;
    }

    public Nod<K> first() {
        return first;
    }

    public Iterator<K> getIterator() {
        return new ListaIterator<>(this);
    }

    void remElmAt(int length) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void remLast() {
        if (first == null) {
            return;
        }

        if (first.getNext() == null) {
            first = null;
        } else {
            TDAListaCell<K> aux = first;
            while (aux.getNext().getNext() != null) {
                aux = aux.getNext();
            }

            aux.setNext(null);
        }
    }
}
