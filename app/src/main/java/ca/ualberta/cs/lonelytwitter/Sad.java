package ca.ualberta.cs.lonelytwitter;

/**
 * Created by steer on 1/17/18.
 */

public class Sad extends Mood {

    /**
     * @param message
     * @return
     */
    String formatMessage(String message) {
        return "[Sad... :( ] " + message;
    }
}
