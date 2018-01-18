package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by steer on 1/17/18.
 */

public class NormalTweet extends Tweet {
    /**
     * @param message
     */
    NormalTweet(String message) {
        super(message);
    }

    /**
     * @param message
     * @param date
     */
    NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * @return
     */
    public boolean isImportant() {
        return false;
    }
}
