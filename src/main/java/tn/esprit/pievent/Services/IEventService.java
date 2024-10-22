package tn.esprit.pievent.Services;

import tn.esprit.pievent.Entity.Event;

import java.time.LocalDate;
import java.util.List;

public interface IEventService {
    public List<Event> retrieveAllEvents();
    public Event retrieveEvent(long idEvent);
    public Event addEvent(Event E);
    public Event updateEvent(Long id, Event event);
    public void removeEvent(long idEvent);
    public boolean eventExists(long eventId);

    List<Event> retrieveEventByDates(LocalDate date);
}
