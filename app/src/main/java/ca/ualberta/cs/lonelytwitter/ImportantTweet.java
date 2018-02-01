/*
 * ImportantTweet.java
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
 * Important tweet class
 */
public class ImportantTweet extends Tweet {
    /**
     * Constructor. Sets the tweets message
     * @param message {@code String} The message to set the tweet to
     */
    ImportantTweet(String message) throws TweetTooLongException {
        super(message);
    }

    /**
     * Constructor. Sets the tweets message and date
     * @param message {@code String} The message to set the tweet to
     * @param date {@code Date} The Date to set the tweet to
     */
    ImportantTweet(String message, Date date) {
        super(message, date);

    }

    /**
     * Returns whether the tweet is important or not
     * @return {@code boolean} Whether the tweet is important or not
     */
    public boolean isImportant() {
        return true;
    }
}
