package org.software.mailing.console;

public class Event {
    private String message;
    private EventType eventType;

    public Event(String message, EventType eventType) {
        this.message = message;
        this.eventType = eventType;
    }

    public String getMessage() {
        return message;
    }

    public EventType getEventType() {
        return eventType;
    }

    public enum EventType {
        START, DONE
    }
}
