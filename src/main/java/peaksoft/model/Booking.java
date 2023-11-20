package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "b_gen")
    @SequenceGenerator(name = "b_gen", sequenceName = "b_seq", allocationSize = 1)
    private long id;
    @OneToOne
    private Customer customer;
    @OneToOne
    private Salon salon;
    @OneToOne
    private Employee employee;

}
