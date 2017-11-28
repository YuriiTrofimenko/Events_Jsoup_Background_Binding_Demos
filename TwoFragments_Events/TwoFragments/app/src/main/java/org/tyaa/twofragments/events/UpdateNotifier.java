package org.tyaa.twofragments.events;

import java.util.ArrayList;

/**
 * Created by admin on 07.09.2017.
 */

public class UpdateNotifier {
    private ArrayList<IOnUpdatedListener> listeners = new ArrayList<>();

    public void addListener(IOnUpdatedListener listener) {
        listeners.add(listener);
    }

    public void fireAction(Object sender, NewsChangedEvent event) {
        for (IOnUpdatedListener l: listeners) {
            l.onUpdated(sender, event);
        }
    }
}
