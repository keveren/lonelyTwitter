package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Mood {

    String mood;

    Date date;

    public void Mood(){
        date = null;
        mood = "";
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract String setMood();

}
