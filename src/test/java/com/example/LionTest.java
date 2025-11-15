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
    private Feline feline;

    @Test(expected = Exception.class)
    public void throwsExceptionIfWrongSex() throws Exception {
        new Lion("Робот", feline);
    }

    @Test
    public void getKittensReturnValueFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        assertEquals("Должен вернуть количество котят из Feline",
                1, lion.getKittens());
    }

    @Test
    public void getKittensShouldCallFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void getFoodReturnListFromFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        Lion lion = new Lion("Самка", feline);
        assertEquals("Метод должен вернуть список от Feline", expected, lion.getFood());
    }

    @Test
    public void getFoodShouldCallFelineEatMeat() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        verify(feline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionIfPredatorThrows() throws Exception {
        doThrow(new Exception("Ошибка")).when(feline).eatMeat();
        Lion lion = new Lion("Самец", feline);
        lion.getFood();
    }

}