/*
 * Tweetable.java
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
 * Tweetable Interface.
 */
public interface Tweetable {
    /**
     * Returns the Message contained within the tweet
     * @return {@String message}
     */
    String getMessage();

    /**
     * Sets the message of a given tweet to a string
     * @param message {@code String} The string to set the message to
     * @throws TweetTooLongException Thrown if the tweet is longer than 80 characters
     */
    void setMessage(String message) throws TweetTooLongException;

    /**
     * Returns the Date contained in the tweet
     * @return {@code Date} the date contained within the tweet
     */
    Date getDate();

    /**
     * Sets the Date contained in the tweet
     * @param date {@code Date} The Date value to store in the tweet
     */
    void setDate(Date date);
}
