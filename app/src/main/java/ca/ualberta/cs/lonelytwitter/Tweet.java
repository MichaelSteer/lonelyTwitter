package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by steer on 1/17/18.
 */



public abstract class Tweet implements Tweetable {


    private String message;
    private Date date;


    Tweet(String message) {
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public Date getDate()  {
        return this.date;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 160) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract boolean isImportant();
}