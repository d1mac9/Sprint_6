package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FelineTest {
    @Mock
    private Feline mockFeline;
    @Spy
    private Feline spyFeline;

    @Test
    void eatMeatReturnList() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(mockFeline.eatMeat()).thenReturn(expected);

        assertEquals(expected, mockFeline.eatMeat());
    }

    @Test
    void getFamilyReturnString() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily());
    }

    @Test
    void getKittensWithParamReturnParamValue() {
        int expected = 1;
        assertEquals(expected, spyFeline.getKittens(1));
    }

    @Test
    void getKittensNoParamInvokeGetKittensWith1() {
        spyFeline.getKittens();
        Mockito.verify(spyFeline, Mockito.times(1)).getKittens(1);
    }
}