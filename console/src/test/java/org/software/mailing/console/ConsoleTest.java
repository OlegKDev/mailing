package org.software.mailing.console;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    @Test
    void update() {
        Console listener = new ConsoleImpl();
        Event eventStart = new Event("Module is running...", Event.EventType.START);
        listener.update(eventStart);

        Event eventDone = new Event("Done", Event.EventType.DONE);
        listener.update(eventDone);
    }
}