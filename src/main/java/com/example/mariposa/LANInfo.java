package com.example.mariposa;

public class LANInfo { // yes, I know this is still pretty gross

    private final long id;
    private final String date;
    private final String semester;
    private final int year;

    private String content = "placeholder for all lan party content";

    public LANInfo(long id) {
        this.id = id;
        this.date = "";
        this.semester = "";
        this.year = 0;
    }

    public LANInfo(long id, String date) {
        this.id = id;
        this.date = date;
        this.semester = "";
        this.year = 0;
    }

    public LANInfo(long id, String semester, int year) {
        this.id = id;
        this.date = "";
        this.semester = semester;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        if (!date.equals("")) getSpecific(date);
        if (!semester.equals("")) getSpecific(semester, year);
        return content;
    }

    private void getSpecific(String date) {
        // TODO return specific lan party info given date
        int month, day;
        int splitsAt = date.indexOf('/');
        month = stringToInt(date.substring(0, splitsAt));
        day = stringToInt(date.substring(splitsAt+1));
        content = "month: " + month + ", day: " + day;
    }

    private void getSpecific(String semester, int year) {
        // TODO return lan party data for a semester
        if (semester.equals("S") || semester.equals("F"))
            content = semester + year;
        else
            content = "something went wrong with semester data";
    }

    private int stringToInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }
    
}
