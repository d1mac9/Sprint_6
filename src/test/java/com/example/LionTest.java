package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@ExtendWith(MockitoExtension.class)
class LionTest {

    private Lion lion;
    @Mock
    private Feline mockFeline;

    @Test
    void getKittensReturnInt() throws Exception {
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
        lion = new Lion("Самец", mockFeline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.getFood("Хищник")).thenReturn(expected);

        assertEquals(expected, lion.getFood());
    }
}