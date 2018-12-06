package events;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class TestEvent extends Event {
    public TestEvent(EventType<? extends Event> eventType) {
        super(eventType);
        this.eventType = null;
    }

    public TestEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
        super(source, target, eventType);
    }
}
