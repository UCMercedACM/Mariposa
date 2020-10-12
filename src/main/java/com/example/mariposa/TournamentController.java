package com.example.mariposa;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TournamentController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/tournament")
    public Tournament getTournament(@RequestParam(value = "tournamentID", defaultValue = "0") int tournamentID) {
        return new Tournament(counter.incrementAndGet(), tournamentID, "data");
    }

    @GetMapping("/tournament/bracket")
    public Tournament getTournamentBracket(@RequestParam(value = "tournamentID", defaultValue = "0") int tournamentID) {
        return new Tournament(counter.incrementAndGet(), tournamentID, "bracket");
    }

    @GetMapping("/tournament/streams")
    public Tournament getTournamentStreams(@RequestParam(value = "tournamentID", defaultValue = "0") int tournamentID) {
        return new Tournament(counter.incrementAndGet(), tournamentID, "streams");
    }

    @GetMapping("/tournament/winners")
    public Tournament getTournamentWinners(@RequestParam(value = "tournamentID", defaultValue = "0") int tournamentID) {
        return new Tournament(counter.incrementAndGet(), tournamentID, "winners");
    }
    
}
