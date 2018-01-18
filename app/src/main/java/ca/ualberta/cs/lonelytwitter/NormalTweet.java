package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by steer on 1/17/18.
 */

public class NormalTweet extends Tweet {
    NormalTweet(String message) {
        super(message);
    }
    NormalTweet(String message, Date date) {
        super(message, date);
    }

    public boolean isImportant() {
        return false;
    }
}
