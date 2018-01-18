package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by steer on 1/17/18.
 */

public abstract class Mood {

    /**
     *
     */
    protected Date date;

    /**
     *
     */
    Mood() {
        this.date = new Date(System.currentTimeMillis());
    }

    /**
     * @param date
     */
    Mood(Date date) {
        this.date = date;
    }

    /**
     * @param message
     * @return
     */
    abstract String formatMessage(String message);
}
