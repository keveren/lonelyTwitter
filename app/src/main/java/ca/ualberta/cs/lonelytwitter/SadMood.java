package ca.ualberta.cs.lonelytwitter;

public class SadMood extends Mood {
    public void SadMood(){
        super.setDate(date);
        super.getDate();
    }

    public String setMood() {
        mood = "Sad";
        return mood;
    }
}
