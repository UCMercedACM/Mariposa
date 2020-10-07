package com.example.mariposa;

public class LANInfo {

    private final long id;
    private final String date;

    private String content = "no date provided";

    public LANInfo(long id, String date) {
        this.id = id;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        if (!date.equals("")) getSpecific(date);
        return content;
    }

    private void getSpecific(String date) {
        // TODO return specific lan party info given date
        int month, day;
        int splitsAt = date.indexOf('.');
        month = stringToInt(date.substring(0, splitsAt));
        day = stringToInt(date.substring(splitsAt+1));
        content = "month: " + month + ", day: " + day;
    }

    private int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }
    
}
