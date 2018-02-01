/*
 * NormalTweet.java
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
import java.util.Date;

/**
 * Normal Tweet. This tweet is not important
 */
public class NormalTweet extends Tweet {
    /**
     * Constructor. Initializes a Tweet with a message
     * @param message {@code String} The Tweet message body
     */
    NormalTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * Constructor. Initializes a Tweet with a message and a date
     * @param message {@code String} The Tweet message body
     * @param date {@code Date} The Date
     */
    NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * Returns whether the tweet is important or not
     * @return {@code boolean} the tweets importantness
     */
    public boolean isImportant() {
        return false;
    }
}
