/*
 * Happy.java
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

/**
 * Happy Mood
 */
public class Happy extends Mood {

    /**
     * Formats the Message with the happy characteristic
     * @param message {@code String} The tweet message body
     * @return {@code String} a Happy formatted Message
     */
    String formatMessage(String message) { return "[Happy! :) ] " + message; }

}
