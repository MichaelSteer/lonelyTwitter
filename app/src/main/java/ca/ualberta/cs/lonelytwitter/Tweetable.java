package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by steer on 1/17/18.
 */

public interface Tweetable {
    String getMessage();
    void setMessage() throws TweetTooLongException;

    Date getDate();
    void setDate();
}
