package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp(){
        feline = new Feline();
    }

    @Test
    public void eatMeatCallGetFoodWithPredatorArgument() throws Exception {
        Feline spyFeline = spy(new Feline());
        List<String> expected = List.of("Жертва1", "Жертва2");
        doReturn(expected).when(spyFeline).getFood("Хищник");
        assertEquals("Метод eatMeat должен возвращать список, полученный из getFood",
                expected, spyFeline.eatMeat());
        verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void getFamilyShouldReturnCatsFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgsShouldReturnOne() {
        assertEquals(1, feline.getKittens());
    }
}