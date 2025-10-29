package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predator;

    @Test(expected = Exception.class)
    public void throwsExceptionIfWrongSex() throws Exception {
        new Lion("Робот", predator);
    }

    @Test
    public void getKittensReturnValueFromFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        assertEquals("Должен вернуть количество котят из Feline",3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnListFromPredator() throws Exception {
        List<String> expected = List.of("Зебра", "Буйвол");
        when(predator.eatMeat()).thenReturn(expected);

        Lion lion = new Lion("Самка", predator);
        assertEquals("Метод должен вернуть список от Predator", expected, lion.getFood());
        verify(predator).eatMeat();
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionIfPredatorThrows() throws Exception {
        doThrow(new Exception("Ошибка")).when(predator).eatMeat();

        Lion lion = new Lion("Самец", predator);
        lion.getFood();
    }

    @Test
    public void hasManeTrueIfMaleAndFalseIfFemale() throws Exception {
        Lion maleLion = new Lion("Самец", predator);
        Lion femaleLion = new Lion("Самка", predator);
        assertTrue("Самец должен иметь гриву", maleLion.doesHaveMane());
        assertFalse("Самка не должна иметь гриву", femaleLion.doesHaveMane());
    }
}