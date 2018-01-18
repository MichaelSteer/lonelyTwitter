package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by steer on 1/17/18.
 */

public interface Tweetable {
    /**
     * @return
     */
    String getMessage();

    /**
     * @param message
     * @throws TweetTooLongException
     */
    void setMessage(String message) throws TweetTooLongException;

    /**
     * @return
     */
    Date getDate();

    /**
     * @param date
     */
    void setDate(Date date);
}
