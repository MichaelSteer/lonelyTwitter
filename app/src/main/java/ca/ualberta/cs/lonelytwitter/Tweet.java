/*
 * Tweet.java
 *
 * Copyright (c) 2018 CMPUT 301, Michael Steer, University of Alberta -- All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the code of
 * student Student behavior at the University of Alberta. You can find a copy of the license in
 * this project. Otherwise please contact steer@ualberta.ca
 *
 * @Author Michael Steer
 * @Date 2018-01-30
 * @Version 0.1
 */

package ca.ualberta.cs.lonelytwitter;

import com.google.gson.annotations.Expose;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by steer on 1/17/18.
 */


/**
 * Abstract base class for a Tweet. Implements the Tweetable Interface
 * @see Tweetable
 */
public abstract class Tweet implements Tweetable {

    @Expose
    private String message;

    @Expose
    private Date date;

    @Expose
    private Set<Mood> moods;

    public static int MessageLengthLimit;

    /**
     * Constructor. Takes in a message as an input
     * @param message {@code String} The message that the tweet will contain
     * @Throws TweetTooLongException Thrown when the tweet is longer than 80 characters
     */
    Tweet(String message) throws TweetTooLongException {
        moods = new HashSet<Mood>();
        if (message.length() < Tweet.MessageLengthLimit) {
            throw new TweetTooLongException();
        }
        this.message = message;
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * Constructor. Takes in a message and a Date as in input
     * @param message {@code String} The message to store in the tweet
     * @param date {@code Date} The Date to store in the tweet
     */
    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    /**
     * Returns the Date stored within the Tweet
     * @return {@code Date} The date
     */
    public Date getDate()  {
        return this.date;
    }

    /**
     * Returns the Message stored within the Tweet
     * @return {@code String} The message
     */
    public String getMessage() {
        String out = this.message;
        for(Mood mood: moods) {
            mood.formatMessage(out);
        }
        return out;
    }

    /**
     * Sets the message to be contained within the tweet
     * @param message {@code String} The message to set
     * @throws TweetTooLongException Thrown if the tweet is longer than 80 characters
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > Tweet.MessageLengthLimit) {
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets the Date to be contained within the tweet
     * @param date {@code Date} The date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Add a mood to the set of moods contained within the tweet
     * @param mood {@code Mood} The mood to add
     */
    public void addMood(Mood mood) {
        moods.add(mood);
    }

    /**
     * Remove a mood from the set of moods contained within the tweet
     * @param mood {@code Mood} The mood to remove
     */
    public void removeMood(Mood mood) {
        moods.remove(mood);
    }

    /**
     * Returns whether a tweet is important or not
     * @return {@code boolean} Whether the tweet is important or not
     */
    public abstract boolean isImportant();

    /**
     * Converts the tweet into a fomratted string
     * @return {@code String} the string formatted tweet
     */
    @Override
    public String toString() {
        return message;
    }
}