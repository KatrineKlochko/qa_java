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
    public void eatMeatShouldReturnPredatorFoodList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals("Метод eatMeat должен возвращать список, полученный из getFood",
                expected, actual);
    }

    @Test
    public void eatMeatShouldCallGetFoodOnce() throws Exception {
        Feline spyFeline = spy(new Feline());
        spyFeline.eatMeat();
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