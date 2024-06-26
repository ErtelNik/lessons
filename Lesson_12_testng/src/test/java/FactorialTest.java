package com.example;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.computeFactorial(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.computeFactorial(1), 1);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(Factorial.computeFactorial(5), 120);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.computeFactorial(-1));
    }
}