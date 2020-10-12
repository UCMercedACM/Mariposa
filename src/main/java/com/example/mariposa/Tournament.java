package com.example.mariposa;

import java.util.Arrays;

public class Tournament {

    private final long id;
    private String content = "";
    private String request = "";

    private static final String[] validRequests = {"data", "bracket", "streams", "winners"};

    public Tournament(long id, int tournamentID, String request) {
        this.id = id;
        this.request = request;
    }

    private static boolean assertValidRequest(String request) {
        return Arrays.asList(validRequests).contains(request);
    }
    
    public long getId() { return id; }

    public String getContent() {
        if (!assertValidRequest(request)) return content = "invalid request";
        if (request.equals("data")) return content = getData();
        if (request.equals("bracket")) return content = getBrackets();
        if (request.equals("streams")) return content = getStreams();
        if (request.equals("winners")) return content = getWinners();
        return content;
    }

    // These will return stuff in JSON from the database
    private String getData() {
        return "data placeholder";
    }

    private String getBrackets() {
        return "brackets placeholder";
    }

    private String getStreams() {
        return "stream data placeholder";
    }

    private String getWinners() {
        return "tourney winners placeholder";
    }

}
