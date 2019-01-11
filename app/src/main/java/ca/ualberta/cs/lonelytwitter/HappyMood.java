package ca.ualberta.cs.lonelytwitter;

public class HappyMood extends Mood {
    public void HappyMood(){
        super.setDate(date);
        super.getDate();
    }

    public String setMood() {
        mood = "Happy";
        return mood;
    }
}
