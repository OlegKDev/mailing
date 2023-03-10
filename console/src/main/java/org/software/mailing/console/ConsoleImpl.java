package org.software.mailing.console;

public class ConsoleImpl implements Console {
    @Override
    public void update(Event event) {
        if (event.getEventType().equals(Event.EventType.START)) {
            System.out.println(event.getMessage());
        }

        if (event.getEventType().equals(Event.EventType.DONE)) {
            System.out.println(event.getMessage() + "\n");
        }
    }
}
