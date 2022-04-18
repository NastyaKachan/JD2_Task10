package by.academy.JD2_Task10.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_task")
@Entity
@DiscriminatorValue("W")
public class WorkTask extends Task{

    @Column
    private Integer cost;
}
