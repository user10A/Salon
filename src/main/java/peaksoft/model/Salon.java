package peaksoft.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salon_gen")
    @SequenceGenerator(name = "salon_gen", sequenceName = "salon_seq", allocationSize = 1)
    private long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "salon")
    private List<Employee> employeeList;
}
