package tn.esprit.pievent;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.pievent.Entity.Event;
import tn.esprit.pievent.Repository.IEventRepository;
import tn.esprit.pievent.Services.EventServicelmpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)

public class EventServiceImplMockTest {

    @Mock
    IEventRepository eventRepository;

    @InjectMocks
    EventServicelmpl eventService;

    Event event = new Event(1, "Event1", LocalDate.now(), 10, "Additional Notes", "Place1");
    List<Event> listEvents = new ArrayList<Event>() {{
        add(new Event(2, "Event2", LocalDate.now(), 20, "Additional Notes2", "Place2"));
        add(new Event(3, "Event3", LocalDate.now(), 30, "Additional Notes3", "Place3"));
    }};

    @Test
    public void testRetrieveAllEvents() {
        Mockito.when(eventRepository.findAll()).thenReturn(listEvents);
        List<Event> events = eventService.retrieveAllEvents();
        Assertions.assertNotNull(events);
    }
    @Test
    public void testRetrieveEvent() {
        Mockito.when(eventRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(event));
        Event event1 = eventService.retrieveEvent(1);
        Assertions.assertNotNull(event1);
    }

    @Test
    public void testAddEvent() {
        Mockito.when(eventRepository.save(Mockito.any(Event.class))).thenReturn(event);
        Event event1 = eventService.addEvent(event);
        Assertions.assertNotNull(event1);
    }

    @Test
    public void testUpdateEvent() {
        Mockito.when(eventRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(event));
        Mockito.when(eventRepository.save(Mockito.any(Event.class))).thenReturn(event);
        Event event1 = eventService.updateEvent(1L, event);
        Assertions.assertNotNull(event1);
    }

    @Test
    public void testRemoveEvent() {
        Mockito.when(eventRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(event));
        eventService.removeEvent(1);
        Mockito.verify(eventRepository, Mockito.times(1)).delete(event);
    }

    @Test
    public void testEventExists() {
        Mockito.when(eventRepository.existsById(Mockito.anyLong())).thenReturn(true);
        boolean exists = eventService.eventExists(1);
        Assertions.assertTrue(exists);
    }

    @Test
    public void testRetrieveEventByDates() {
        Mockito.when(eventRepository.findByDate(Mockito.any(LocalDate.class))).thenReturn(listEvents);
        List<Event> events = eventService.retrieveEventByDates(LocalDate.now());
        Assertions.assertNotNull(events);
        Assertions.assertEquals(2, events.size());
    }
}
