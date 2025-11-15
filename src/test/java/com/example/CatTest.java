package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @InjectMocks
    private Cat cat;

    @Test
    public void getSoundReturnMeow() {
        assertEquals("Метод getSound должен возвращать 'Мяу'","Мяу", cat.getSound());
    }

    @Test
    public void getFoodShouldReturnListFromFeline() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        assertEquals("Метод getFood должен возвращать список от Feline",
                expected, actual);
    }

    @Test
    public void getFoodShouldCallEatMeatOnce() throws Exception{
        cat.getFood();
        verify(feline).eatMeat();
    }
}