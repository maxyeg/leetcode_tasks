package edu.leetcode.maxeg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryTest {
    @Test
    public void addBinaryTest() {
        assertEquals("100", AddBinary.addBinary("11", "1"));
        assertEquals("10101", AddBinary.addBinary("1010", "1011"));
    }
}