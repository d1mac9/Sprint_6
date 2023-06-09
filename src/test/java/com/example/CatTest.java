package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatTest {
    private Cat cat;

    @Test
    void getSoundNoParamReturnString() {
        cat = new Cat(new Feline());
        String expected = "Мяу";

        assertEquals(expected, cat.getSound());
    }

    @Test
    void getFoodNoParamReturnList() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        cat = new Cat(mockFeline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expected);

        assertEquals(expected, cat.getFood());
    }
}