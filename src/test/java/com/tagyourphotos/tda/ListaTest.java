/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author george
 */
public class ListaTest {
    
    private Lista<String> lista;
    
    public ListaTest() {
    }
    
    @Before
    public void setUp() {
        lista = new Lista<>();
        lista.append("1");
        lista.append("2");
        lista.append("3");
        lista.append("4");
        lista.append("5");
    }
    
    @After
    public void tearDown() {
        lista = null;
    }

    /**
     * Test of addFirst method, of class Lista.
     */
    @Test
    public void testAddFirst() {
        lista.addFirst("0");
        assertEquals(6, lista.length());
        assertEquals("0", lista.first().getInfo());
    }

    /**
     * Test of remFirst method, of class Lista.
     */
    @Test
    public void testRemFirst() {
        lista.remFirst();
        assertEquals(4, lista.length());
        assertEquals("2", lista.first().getInfo());
    }
    
    /**
     * Test of remLast method, of class Lista.
     */
    @Test
    public void testRemLast() {
        lista.remLast();
        assertEquals(4, lista.length());
        assertEquals("4", lista.getElementAt(3).getInfo());
    }

    /**
     * Test of addElmAt method, of class Lista.
     */
    @Test
    public void testAddElmAt() {
        lista.addElmAt("10", 1);
        assertEquals(6, lista.length());
        assertEquals("10", lista.getElementAt(1).getInfo());
    }
    
    /**
     * Test of length method, of class Lista.
     */
    @Test
    public void testLength() {
        assertEquals(5, lista.length());
    }

    /**
     * Test of isEmpty method, of class Lista.
     */
    @Test
    public void testIsEmpty() {
        assertEquals(false, lista.isEmpty());
    }

    /**
     * Test of isDefAt method, of class Lista.
     */
    @Test
    public void testIsDefAt() {
        assertEquals(true, lista.isDefAt(3));
    }

    /**
     * Test of member method, of class Lista.
     */
    @Test
    public void testMember() {
        assertEquals(true, lista.member("1"));
    }

    /**
     * Test of append method, of class Lista.
     */
    @Test
    public void testAppend() {
        lista.append("6");
        assertEquals(6, lista.length());
    }

    /**
     * Test of getElementAt method, of class Lista.
     */
    @Test
    public void testGetElementAt() {
        assertEquals("3", lista.getElementAt(2).getInfo());
    }
    
}
