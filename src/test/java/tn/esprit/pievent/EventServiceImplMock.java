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
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class EventServiceImplMock {

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
}
