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
public class DictionarTest {

    private Dictionar<String, Vector<Integer>> dictionarTest = new Dictionar<>();
    
    public DictionarTest() {
        
    }

    @Before
    public void setUp() {
        Vector<Integer> values = new Vector<>(4);
        values.add(1);
        values.add(2);
        values.add(3);

        Vector<Integer> values2 = new Vector<>(4);
        values2.add(4);
        values2.add(5);
        
        dictionarTest.add("3", values);
        dictionarTest.add("2", values2);
    }

    @After
    public void tearDown() {
        dictionarTest = null;
    }

    /**
     * Test of add method, of class Dictionar.
     */
    @Test
    public void testAdd() {
        assertEquals(true, dictionarTest.containsKey("3"));
        assertEquals(true, dictionarTest.containsKey("2"));
        assertEquals(3, dictionarTest.getValue("3").getSize());
        assertEquals(2, dictionarTest.getValue("2").getSize());
        
        Vector<Integer> v = new Vector<>();
        v.add(10);
        dictionarTest.add("10", v);
        
        assertEquals(true, dictionarTest.containsKey("10"));
        assertEquals(1, dictionarTest.getValue("10").getSize());
    }

    /**
     * Test of containsKey method, of class Dictionar.
     */
    @Test
    public void testContainsKey() {
        assertEquals(true, dictionarTest.containsKey("3"));
        assertEquals(true, dictionarTest.containsKey("2"));
        assertEquals(false, dictionarTest.containsKey("5"));
    }

    /**
     * Test of values method, of class Dictionar.
     */
    @Test
    public void testValues() {
        assertEquals(3, dictionarTest.getValue("3").getSize());
        assertEquals(2, dictionarTest.getValue("2").getSize());
        
        Vector<Integer> v = dictionarTest.getValue("3");
        assertEquals(new Integer(1), v.getElementAt(0));
        assertEquals(new Integer(2), v.getElementAt(1));
        assertEquals(new Integer(3), v.getElementAt(2));
    }

}
