package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LionTest {

    private Lion lion;

    @Test
    void getKittensReturnInt() throws Exception {
        Feline mockFeline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", mockFeline);
        Mockito.when(mockFeline.getKittens()).thenReturn(1);
        int expected = 1;
        assertEquals(expected, lion.getKittens());
    }

    static Stream<Arguments> doesHaveManeTestData() {
        return Stream.of(
                arguments("Самец", true),
                arguments("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("doesHaveManeTestData")
    void doesHaveManeParams(String sex, boolean hasMane) throws Exception {
        lion = new Lion(sex, new Feline());
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    void constructorUnsupportedAnimalType() {
        String expectedText = "Используйте допустимые значения пола животного - самец или самка";
        Exception thrown = assertThrows(
                Exception.class,
                () -> new Lion("Неподдерживаемый", new Feline()));

        assertEquals(expectedText, thrown.getMessage());
    }

    @Test
    void getFoodReturnList() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);

        assertEquals(expected, lion.getFood());
    }
}