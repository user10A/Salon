package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_gen")
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq", allocationSize = 1)
    private long id;
    private String name;
    private String surname;
    private int salary;
    private String position;
    @ManyToOne
    private Salon salon;

}
