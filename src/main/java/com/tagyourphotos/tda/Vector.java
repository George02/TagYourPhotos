/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda;

/**
 *
 * @param <K> Tipul elementelor din vector
 */
public class Vector<K> {
    
    private int MAX_SIZE = 10;
    
    private int size;
    private K vector[];

    public Vector(){
        this.size = 0;
        this.vector = (K[])new Object[MAX_SIZE];
    }
    
    public Vector(Vector<K> v){
        this(v.getMaxSize());
        for(int i = 0; i < v.getSize(); i++){
            this.add(v.getElementAt(i));
        }
    }
    
    public Vector(int maxSize){
        this.size = 0;
        this.MAX_SIZE = maxSize;
        this.vector = (K[])new Object[MAX_SIZE];
    }
    
    /**
     * Adauga un element in vector
     * @param element Elementul ce urmeaza a fi inserat in vector
     * @return True daca elementul a fost inserat cu success, false altfel.
     */
    public boolean add(K element){
        if(size == MAX_SIZE){
            return false;
        }else{
            vector[size++] = element;
            return true;
        }
    }

    public int getSize() {
        return size;
    }
    
    public int getMaxSize(){
        return MAX_SIZE;
    }
    
    public K getElementAt(int index){
        return this.vector[index];
    }

    /**
     * Cauta un element in vector
     * @param element Elementul cautat
     * @return True daca elementul a fost gasit - false, altfel.
     */
    boolean contains(K element) {
        for(K vItem : vector){
            if(element.equals(vItem)){
                return true;
            }
        }
        
        return false;
    }
    
    public static void copyAll(Vector v1, Vector v2){
        for(int i = 0; i < v2.getSize(); i++){
            v1.add(v2.getElementAt(i));
        }
    }
    
}
