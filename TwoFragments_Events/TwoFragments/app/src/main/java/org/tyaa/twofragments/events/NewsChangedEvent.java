package org.tyaa.twofragments.events;

import java.util.EventObject;

/**
 * Created by student on 30.09.2017.
 */

public class NewsChangedEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public int selectedItemId;
    public NewsChangedEvent(Object source) {
        super(source);
    }
}
