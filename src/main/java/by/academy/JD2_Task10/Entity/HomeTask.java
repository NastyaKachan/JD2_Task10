package by.academy.JD2_Task10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "home_task")
@Entity
@DiscriminatorValue("H")
public class HomeTask extends Task {
    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "e_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "e_surname"))
    })
    Person executor;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "s_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "s_surname"))
    })
    Person supervisor;


}
