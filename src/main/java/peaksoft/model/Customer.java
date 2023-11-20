package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    @SequenceGenerator(name = "customer_gen", sequenceName = "customer_seq", allocationSize = 1)
    private long id;

    private String name;
    @ManyToMany
    private List<Salon> salon;
    @OneToMany
    private List<Booking> bookings;
}
