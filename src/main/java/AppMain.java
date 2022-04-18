import Entity.HomeTask;
import Entity.Person;
import Entity.Task;
import Entity.WorkTask;
import Util.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class AppMain {
    public static void main(String[] args) {
        Person executorPerson = Person.builder().name("Elena").surname("Durova").build();
        Person supervisorPerson = Person.builder().name("Olga").surname("Zvereva").build();

        Task homeTask = HomeTask.builder()
                .name("task3.1")
                .description("hometask3")
                .startDate(LocalDate.of(2022,04,12))
                .endDate(LocalDate.of(2022,04,15))
                .executor(executorPerson)
                .supervisor(supervisorPerson)
                .build();

        Task workTask = WorkTask.builder()
                .name("task3.2")
                .description("worktask3")
                .cost(10)
                .build();

        Task task = Task.builder()
                .name("task_mapping")
                .description("mapping")
                .build();

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(homeTask);
        entityManager.persist(workTask);
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        //HibernateUtil.close();
    }
}
