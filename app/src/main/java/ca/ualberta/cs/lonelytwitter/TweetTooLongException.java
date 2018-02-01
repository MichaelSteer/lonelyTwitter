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

import java.lang.Exception;

/**
 * The TweetTooLong Exception. This execption is thrown if the tweet is too long
 */
public class TweetTooLongException extends Exception {
    /**
     * Super Constructor
     * @param e {@code string} message
     */
    public TweetTooLongException(String e) {
        super(e);
    }

    /**
     * super Constructor
     */
    public TweetTooLongException() {
        super();
    }
}
