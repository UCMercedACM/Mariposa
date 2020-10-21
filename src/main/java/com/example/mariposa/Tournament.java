package com.example.mariposa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tournament {

    private @Id @GeneratedValue Long tournamentID;
    private String bracket, stream, winner;

    public Tournament(long tournamentID, String bracket, String stream, String winner) {
        this.tournamentID = tournamentID;
        this.bracket = bracket;
        this.stream = stream;
        this.winner = winner;
    }

    public String getBracket() {
        return this.bracket;
    }

    public String getStream() {
        return this.stream;
    }

    public String getWinner() {
        return this.winner;
    }

}
