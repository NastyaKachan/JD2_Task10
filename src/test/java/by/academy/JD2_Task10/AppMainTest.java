package by.academy.JD2_Task10;

import by.academy.JD2_Task10.Entity.HomeTask;
import by.academy.JD2_Task10.Entity.Person;
import by.academy.JD2_Task10.Entity.Task;
import by.academy.JD2_Task10.Entity.WorkTask;
import by.academy.JD2_Task10.Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppMainTest {
    Task hometask;
    Task workTask;

    @Before
    public void beforeTest() {
        hometask = HomeTask.builder()
                .name("hometest")
                .description("home_desc")
                .startDate(LocalDate.of(2022, 01, 01))
                .endDate(LocalDate.of(2022, 02, 02))
                .executor(new Person("Ivan", "Ivanov"))
                .supervisor(new Person("Petr", "Petrov"))
                .build();
        workTask = WorkTask.builder()
                .name("worktest")
                .description("work_desc")
                .cost(15)
                .build();

    }

    @Test
    public void addHometaskTest() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(hometask);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        HomeTask hometaskFromBase = entityManager.find(HomeTask.class, hometask.getId());
        Assert.assertEquals(hometaskFromBase, hometask);
        Assert.assertEquals(hometaskFromBase.getId(), hometask.getId());
        Assert.assertEquals(hometaskFromBase.getName(), hometask.getName());
        Assert.assertEquals(hometaskFromBase.getDescription(), hometask.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        HibernateUtil.close();
    }

    @Test
    public void addWorktaskTest() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(workTask);
            entityManager.getTransaction().commit();
        } catch (HibernateException e) {
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        WorkTask worktaskFromBase = entityManager.find(WorkTask.class, workTask.getId());
        Assert.assertEquals(worktaskFromBase, workTask);
        Assert.assertEquals(worktaskFromBase.getId(), workTask.getId());
        Assert.assertEquals(worktaskFromBase.getName(), workTask.getName());
        Assert.assertEquals(worktaskFromBase.getDescription(), workTask.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        HibernateUtil.close();

    }

}
