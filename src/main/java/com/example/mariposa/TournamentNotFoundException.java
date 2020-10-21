package com.example.mariposa;

public class TournamentNotFoundException extends RuntimeException{

    TournamentNotFoundException(Long tournamentID) {
        super("Could not find employee " + tournamentID);
    }

}
