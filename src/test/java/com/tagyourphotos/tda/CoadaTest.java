/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos.tda;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author george
 */
public class CoadaTest {
    
    /**
     * Test of pop method, of class Coada.
     */
    @Test
    public void testPop() {
        Coada<String> coada = new Coada<String>();
        coada.push("1");
        coada.push("2");
        assertEquals("1", coada.pop().getInfo());
    }

    /**
     * Test of push method, of class Coada.
     */
    @Test
    public void testPush() {
        Coada<String> coada = new Coada<String>();
        coada.push("1");
        assertEquals("1", coada.pop().getInfo());
    }

    /**
     * Test of inverseaza method, of class Coada.
     */
    @Test
    public void testInverseaza() {
        Coada<String> c = new Coada<>();

        c.push("1");
        c.push("2");
        c.push("3");

        c.inverseaza();

        assertEquals("3", c.pop().getInfo());
        assertEquals("2", c.pop().getInfo());
        assertEquals("1", c.pop().getInfo());
    }

}
