package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LionAlexTest {

    private LionAlex lion;

    @BeforeEach
    void setUp() throws Exception {
        lion = new LionAlex();
    }

    @Test
    void getFriendsReturnList() {
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");

        assertEquals(expected, lion.getFriends());
    }

    @Test
    void getPlaceOfLivingReturnString() {
        String expected = "Нью-Йоркский зоопарк";

        assertEquals(expected, lion.getPlaceOfLiving());
    }

    @Test
    void getKittensReturnInt() {
        int expected = 0;

        assertEquals(expected, lion.getKittens());
    }
}