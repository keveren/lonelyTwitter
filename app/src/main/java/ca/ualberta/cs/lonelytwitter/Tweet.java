package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public abstract class Tweet {
    //class atributes
    String message;

    Date date;
    //construtor
    public void Tweet(){

        message = "";

    }

    public void setMessage(String tweetmessage){
        message = tweetmessage;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String tweetmessage, String message2){
        message = tweetmessage;
        this.message = message2;

        System.out.println("Second message has been called");

    }

    public abstract String getSomething();

    //override
    public String toString(){
        return message;
    }
}