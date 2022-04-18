package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "worktask_subclass")
@Entity
@SuperBuilder
@PrimaryKeyJoinColumn(name = "task_id")
public class WorkTask extends Task{
    @Column
    private Integer cost;
}
