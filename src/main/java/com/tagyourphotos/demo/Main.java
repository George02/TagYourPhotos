/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.demo;

import com.tagyourphotos.tda.Coada;
import com.tagyourphotos.tda.Dictionar;
import com.tagyourphotos.tda.Iterator;
import com.tagyourphotos.tda.Lista;
import com.tagyourphotos.tda.Vector;

/**
 *
 * @author george
 */
public class Main {
    
    public static void main(String[] args){
        demoRuh();
        System.out.println();
        demoTG();
    }
    
    private static void demoTG(){
        Lista<String> l = new Lista<String>();
        l.append("a");
        l.append("b");
        l.append("a");
        l.append("c");
        l.append("c");
        l.append("d");
        l.append("b");
        
        Vector<Lista<String>> v = getVectorDeListe(l);
        for(int i = 0; i <  v.getSize(); i++){
            Lista<String> ll = v.getElementAt(i);
            Iterator<String> it = ll.getIterator();
            while(it.hasNext()){
                System.out.print(it.get().getInfo() + " ");
            }
            System.out.println();
        }
    }
    
    private static void demoRuh(){
        System.out.println("Construiesc coada: 3 2 1");
        
        Coada<String> c = new Coada<String>();
        c.push("1");
        c.push("2");
        c.push("3");
        
        c.inverseaza();
        
        String e1 = c.pop().getInfo();
        String e2 = c.pop().getInfo();
        String e3 = c.pop().getInfo();
        
        System.out.print("Coada inversata: " + e3 + " " + e2 + " " + e1);
        System.out.println();
    }

    private static Vector<Lista<String>> getVectorDeListe(Lista<String> l) {
        Vector<Lista<String>> vectorDeListe = new Vector<>();
        Dictionar<String, Vector<String>> d = new Dictionar<>();
        int contor =  0;
        Iterator<String> it = l.getIterator();
        while(it.hasNext()){
            String tag = it.get().getInfo();
            if(!d.containsKey(tag)){
                d.add(tag, new Vector<>());
            }
            
            d.getValue(tag).add(String.valueOf(contor));
            contor++;
        }
        
        it = d.getKeysSet().getIterator();
        while(it.hasNext()){
            String key = it.get().getInfo();
            Vector<String> values = d.getValue(key);
            
            Lista<String> ll = new Lista<>();
            
            for(int i = 0; i < values.getSize(); i++){
                ll.append(values.getElementAt(i));
            }
            
            vectorDeListe.add(ll);
        }
        
        return vectorDeListe;
    }
    
}
