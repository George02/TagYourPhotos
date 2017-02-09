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
public class VectorTest {

    private Vector<String> vector5;

    public VectorTest() {

    }

    @Before
    public void setUp() {
        vector5 = new Vector<>();
        vector5.add("1");
        vector5.add("2");
        vector5.add("3");
        vector5.add("4");
        vector5.add("5");
    }

    @After
    public void tearDown() {
        vector5 = null;
    }

    @Test
    public void testAdd() {
        Vector<String> v = new Vector<String>(vector5);
        v.add("6");

        assertEquals(vector5.getSize() + 1, v.getSize()); //dimensiunea vectorului a crescut
        assertEquals(true, v.contains("6")); //vectorul contine elementul adaugat
    }

    @Test
    public void testAddWhenEmpty() {
        Vector<String> v = new Vector<>();
        v.add("1");

        assertEquals(1, v.getSize()); //dimensiunea vectorului a crescut
        assertEquals(true, v.contains("1")); //vectorul contine elementul adaugat
    }

    @Test
    public void testAddWhenFull() {
        boolean adaugat;
        
        Vector<String> v = new Vector(3);
        for (int i = 0; i < 3; i++) {
            adaugat = v.add(String.valueOf(i));
            assertEquals(true, adaugat);
        }

        adaugat = v.add("4");

        assertEquals(3, v.getSize()); //dimensiunea vectorului a crescut
        assertEquals(false, v.contains("4")); //vectorul contine elementul adaugat
        assertEquals(false, adaugat); //vectorul contine elementul adaugat
    }

    @Test
    public void testGetMaxSize1() {
        assertEquals(10, new Vector().getMaxSize());
    }
    
    @Test
    public void testGetMaxSize2() {
        assertEquals(100, new Vector(100).getMaxSize());
    }
    
    @Test
    public void testGetSize1() {
        assertEquals(0, new Vector().getSize());
    }
    
    @Test
    public void testGetSize2() {
        assertEquals(5, vector5.getSize());
    }

}
