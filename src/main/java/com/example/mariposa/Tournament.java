package com.example.mariposa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.net.URL;

public class Tournament {

    private final long id;
    private String content = "";

    private long tournamentID;
    private String request = "";

    private static final String[] validRequests = {"data", "bracket", "streams", "winners"};

    private Map<Long, ArrayList<String>> tournaments = new HashMap<>();

    // I don't REALLY like this implementation, the way this is now it has to parse
    // all of the data from the database with every request...
    public Tournament(long id, int tournamentID, String request) {
        this.id = id;

        this.tournamentID = tournamentID;
        this.request = request;

        parseJSON();
    }

    private static boolean assertValidRequest(String request) {
        return Arrays.asList(validRequests).contains(request);
    }
    
    public long getId() { return id; }

    public String getContent() {
        if (!tournaments.keySet().contains(tournamentID)) return content = "Invalid Tournament ID";
        if (!assertValidRequest(request)) return content = "Invalid Request";
        if (request.equals("data"))       return content = getData();
        if (request.equals("bracket"))    return content = getBracket();
        if (request.equals("streams"))    return content = getStream();
        if (request.equals("winners"))    return content = getWinner();
        return content;
    }

    @SuppressWarnings("unchecked")
    // put data from database into local map
    private void parseJSON() {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        URL path = Tournament.class.getResource("MOCK_DATA.json");
         
        try (FileReader reader = new FileReader(path.getFile()))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray tournamentList = (JSONArray) obj;
             
            //Iterate over tournament array
            tournamentList.forEach(tournament -> parseTournament( (JSONObject) tournament));
 
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // helper func to populate the local map
    private void parseTournament(JSONObject tournament) {
        ArrayList<String> temp = new ArrayList<>();
        temp.add((String) tournament.get("bracket")); // bracket will always be in 0 index
        temp.add((String) tournament.get("stream")); // stream link will always be in 1 index
        temp.add((String) tournament.get("winner")); // winner name will always be in 2 index

        tournaments.put((Long) tournament.get("tournamentID"), temp);
    }

    @SuppressWarnings("unchecked")
    private String getData() {
        JSONObject temp = new JSONObject();
        temp.put("bracket", tournaments.get(tournamentID).get(0));
        temp.put("stream", tournaments.get(tournamentID).get(1));
        temp.put("winner", tournaments.get(tournamentID).get(2));
        return temp.toString();
    }

    @SuppressWarnings("unchecked")
    private String getBracket() {
        JSONObject temp = new JSONObject();
        temp.put("bracket", tournaments.get(tournamentID).get(0));
        return temp.toString();
    }

    @SuppressWarnings("unchecked")
    private String getStream() {
        JSONObject temp = new JSONObject();
        temp.put("stream", tournaments.get(tournamentID).get(1));
        return temp.toString();
    }

    @SuppressWarnings("unchecked")
    private String getWinner() {
        JSONObject temp = new JSONObject();
        temp.put("winner", tournaments.get(tournamentID).get(2));
        return temp.toString();
    }

}
