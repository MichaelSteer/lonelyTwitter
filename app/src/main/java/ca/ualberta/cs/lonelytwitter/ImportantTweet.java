package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by steer on 1/17/18.
 */

public class ImportantTweet extends Tweet {
    /**
     * @param message
     */
    ImportantTweet(String message) {
        super(message);
    }

    /**
     * @param message
     * @param date
     */
    ImportantTweet(String message, Date date) {
        super(message, date);

    }

    /**
     * @return
     */
    public boolean isImportant() {
        return true;
    }
}
