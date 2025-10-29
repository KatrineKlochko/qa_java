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
    public void getFoodReturnPredatorList() throws Exception {
        List<String> expected = List.of("Мышь", "Птица");
        when(feline.eatMeat()).thenReturn(expected);
        assertEquals("Метод getFood должен возвращать список от Predator",
                expected, cat.getFood());
        verify(feline).eatMeat();
        verifyNoMoreInteractions(feline);
    }
}