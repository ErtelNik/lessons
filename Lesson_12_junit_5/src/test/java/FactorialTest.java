package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.computeFactorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, Factorial.computeFactorial(1));
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(120, Factorial.computeFactorial(5));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.computeFactorial(-1));
    }
}