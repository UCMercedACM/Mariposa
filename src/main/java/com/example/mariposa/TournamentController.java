package com.example.mariposa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@EnableJpaRepositories
@RestController
public class TournamentController {

    @Autowired
    private final TournamentRepostitory repository;

    TournamentController(TournamentRepostitory repository) {
        this.repository = repository;
    }

    @GetMapping("/tournament/{tournamentID}")
    Tournament getTournament(@PathVariable Long tournamentID) {
        return repository.findById(tournamentID).orElseThrow(() -> new TournamentNotFoundException(tournamentID));
        // return new Tournament(0, "bracket", "stream", "winner");
    }

    // @GetMapping("/tournament/bracket")
    // Tournament getTournamentBracket(@RequestParam(value = "tournamentID", defaultValue = "0") Long tournamentID) {
    //     return new Tournament(tournamentID, "bracket");
    // }

    // @GetMapping("/tournament/streams")
    // Tournament getTournamentStreams(@RequestParam(value = "tournamentID", defaultValue = "0") Long tournamentID) {
    //     return new Tournament(tournamentID, "streams");
    // }

    // @GetMapping("/tournament/winners")
    // Tournament getTournamentWinners(@RequestParam(value = "tournamentID", defaultValue = "0") Long tournamentID) {
    //     return new Tournament(tournamentID, "winners");
    // }

}
