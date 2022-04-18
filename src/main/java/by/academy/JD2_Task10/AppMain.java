package by.academy.JD2_Task10;

import by.academy.JD2_Task10.Entity.HomeTask;
import by.academy.JD2_Task10.Entity.Person;
import by.academy.JD2_Task10.Entity.Task;
import by.academy.JD2_Task10.Entity.WorkTask;
import by.academy.JD2_Task10.Util.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class AppMain {
    public static void main(String[] args) {

        Person executorPerson = Person.builder().name("Oleg").surname("Ivanov").build();
        Person supervisorPerson = Person.builder().name("Vadim").surname("Petrov").build();

        Task homeTask = HomeTask.builder()
                .name("task1")
                .description("hometask1")
                .startDate(LocalDate.of(2022,04,14))
                .endDate(LocalDate.of(2022,04,18))
                .executor(executorPerson)
                .supervisor(supervisorPerson)
                .build();

        Task workTask = WorkTask.builder()
                .name("task2")
                .description("worktask2")
                .cost(10)
                .build();

        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(homeTask);
        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        entityManager.close();
        HibernateUtil.close();

    }
}
