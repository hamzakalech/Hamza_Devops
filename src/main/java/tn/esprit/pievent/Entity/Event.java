package tn.esprit.pievent.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEvent;
    private String description;
    private LocalDate date;
    private int Number_of_tickets;
    private String additional_notes;
    private String place;







}
