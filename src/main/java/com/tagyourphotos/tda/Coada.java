/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda;

/**
 *
 * @author Ruh
 */
public class Coada<K> {

    //FIFO
    private final Lista<K> lista;

    public Coada() {
        lista = new Lista<>();
    }

    public Nod<K> pop() {
        Nod<K> item = first();
        if(item == null){
            return null;
        }
        
        lista.remFirst();
        return item;
    }

    public void push(K item) {
        lista.append(item);
    }

    /**
     * Primul in coada este chiar primul din lista
     *
     * @return
     */
    public Nod<K> first() {
        return lista.first();
    }

    /**
     * Ultimul din coada este ultimul element adaugat in lista
     *
     * @return
     */
    public Nod<K> last() {
        return lista.getElementAt(lista.length());
    }

    /**
     * Pentru inversarea cozii se parcurge lista pana la jumatate si se inlocuieste primul element cu ultimul
     * al doilea cu penultimul etc.
     */
    public void inverseaza() {
        int contor = 0;
        int dimensiuneCoada = lista.length();
        Iterator<K> iterator = lista.getIterator();
        while (iterator.hasNext()) {
            if (contor == dimensiuneCoada / 2) {
                break;
            }

            Nod<K> primulDeLaCoada = lista.getElementAt(contor);
            Nod<K> ultimulDeLaCoada = lista.getElementAt(dimensiuneCoada - 1 - contor);
            lista.remFirst();
            lista.remLast();
            lista.append(primulDeLaCoada.getInfo());
            lista.addFirst(ultimulDeLaCoada.getInfo());

            contor++;
        }
    }
}
