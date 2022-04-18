package by.academy.JD2_Task10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Person {

    @Column
    private String name;

    @Column
    private String surname;
}
