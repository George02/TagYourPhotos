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
public interface Iterator<K> {
    boolean hasNext();
    Nod<K> get();
}
