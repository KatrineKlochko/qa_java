package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParamTest {

    private final int input;
    private final int expected;
    private final Feline feline = new Feline();

    public FelineParamTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "getKittens({0}) => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {5, 5},
                {10, 10},
                {100, 100}
        });
    }

    @Test
    public void getKittensReturnSameValueAsArgument() {
        assertEquals(expected, feline.getKittens(input));
    }
}
