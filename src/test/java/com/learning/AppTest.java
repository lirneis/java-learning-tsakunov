package com.learning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Простой тест для метода add класса App.
 */
class AppTest {

    @Test
    void addReturnsSumOfTwoNumbers() {
        assertEquals(5, App.add(2, 3));
        assertEquals(0, App.add(-1, 1));
        assertEquals(-5, App.add(-2, -3));
    }
}
