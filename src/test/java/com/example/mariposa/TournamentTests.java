package com.example.mariposa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class TournamentTests {
    
    @Test
    void validRequest() {
        Tournament test = new Tournament(0, 0, "winners");
        Assert.isTrue(test.getContent().equals("tourney winners placeholder"), "");
    }

    @Test
    void invalidRequest() {
        Tournament test = new Tournament(0, 0, "bleh");
        Assert.isTrue(test.getContent().equals("invalid request"), "");
    }

}
