/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.productapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class ProductCalculationsTest {
    
    public ProductCalculationsTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of GetVat method, of class ProductCalculations.
     */
    @Test
    public void testGetVat() {
        System.out.println("GetVat");
        ProductCalculations instance = null;
        double expResult = 0.0;
        double result = instance.GetVat();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetCommission method, of class ProductCalculations.
     */
    @Test
    public void testGetCommission() {
        System.out.println("GetCommission");
        ProductCalculations instance = null;
        double expResult = 0.0;
        double result = instance.GetCommission();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetTotal method, of class ProductCalculations.
     */
    @Test
    public void testGetTotal() {
        System.out.println("GetTotal");
        ProductCalculations instance = null;
        double expResult = 0.0;
        double result = instance.GetTotal();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
