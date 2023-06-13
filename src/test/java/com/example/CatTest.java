package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CatTest {
    private Cat cat;

    @Mock
    private Feline mockFeline;

    @Test
    void getSoundNoParamReturnString() {
        cat = new Cat(new Feline());
        String expected = "Мяу";

        assertEquals(expected, cat.getSound());
    }

    @Test
    void getFoodNoParamReturnList() throws Exception {
        cat = new Cat(mockFeline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expected);

        assertEquals(expected, cat.getFood());
    }
}