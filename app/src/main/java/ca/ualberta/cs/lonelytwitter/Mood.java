/*
 * Mood.java
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
 * Abstract Mood class
 */
public abstract class Mood {

    protected Date date;

    /**
     * Mood constructor.
     */
    Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * Mood constructor. Sets the date with an inputted date
     * @param date {@code Date} The date input
     */
    Mood(Date date) {
        this.date = date;
    }

    /**
     * Formats a message with a mood string
     * @param message {@code String} The tweet body
     * @return {@code String} the formatted message
     */
    abstract String formatMessage(String message);
}
