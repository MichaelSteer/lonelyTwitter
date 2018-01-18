package ca.ualberta.cs.lonelytwitter;
import java.lang.Exception;

/**
 * Created by steer on 1/17/18.
 */

public class TweetTooLongException extends Exception {
    /**
     * @param e
     */
    public TweetTooLongException(String e) {
        super(e);
    }

    /**
     *
     */
    public TweetTooLongException() {
        super();
    }
}
