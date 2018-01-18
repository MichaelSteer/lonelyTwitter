package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by steer on 1/17/18.
 */



public abstract class Tweet implements Tweetable {


    private String message;
    private Date date;
    private Set<Mood> moods;

    /**
     * @param message
     */
    Tweet(String message) {
        moods = new HashSet<Mood>();
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * @param message
     * @param date
     */
    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    /**
     * @return
     */
    public Date getDate()  {
        return this.date;
    }

    /**
     * @return
     */
    public String getMessage() {
        String out = this.message;
        for(Mood mood: moods) {
            mood.formatMessage(out);
        }
        return out;
    }

    /**
     * @param message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 160) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @param mood
     */
    public void addMood(Mood mood) {
        moods.add(mood);
    }

    /**
     * @param mood
     */
    public void removeMood(Mood mood) {
        moods.remove(mood);
    }

    /**
     * @return
     */
    public abstract boolean isImportant();
}