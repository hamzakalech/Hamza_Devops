package tn.esprit.pievent.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.pievent.Entity.Event;
import tn.esprit.pievent.Repository.IEventRepository;

import java.time.LocalDate;
import java.util.List;
@EnableScheduling
@Service
@AllArgsConstructor
public class EventServicelmpl implements IEventService{
    @Autowired
    IEventRepository eventRepository ;
    @Override
    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event retrieveEvent(long idEvent) {
        return eventRepository.findById(idEvent).get();
    }

    @Override
    public Event addEvent(Event E) {
        return eventRepository.save(E);
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        Event existingEvent = retrieveEvent(id);
        existingEvent.setDescription(event.getDescription());
        existingEvent.setDate(event.getDate());
        existingEvent.setNumber_of_tickets(event.getNumber_of_tickets());
        existingEvent.setAdditional_notes(event.getAdditional_notes());
        existingEvent.setPlace(event.getPlace());
        return eventRepository.save(existingEvent);
    }

    @Override
    public void removeEvent(long idEvent) {
        Event event = eventRepository.findById(idEvent).orElseThrow();
        eventRepository.delete(event);
    }

    @Override
    public boolean eventExists(long eventId) {
        return eventRepository.existsById(eventId);
    }


    @Override
    public List<Event> retrieveEventByDates(LocalDate date) {
        return eventRepository.findByDate(date);
    }





    }



