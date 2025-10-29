package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionParamTest {

    private final String sex;
    private final Boolean expectedHasMane;

    public LionParamTest(String sex, Boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "{index}: Lion({0}) → mane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Test
    public void lionHasManeDependingOnSex() throws Exception {
        Predator predator = mock(Predator.class);
        Lion lion = new Lion(sex, predator);
        assertEquals("Некорректное значение поля hasMane для пола: " + sex,
                expectedHasMane, lion.doesHaveMane());
    }

}
