import Entity.HomeTask;
import Entity.Person;
import Entity.Task;
import Entity.WorkTask;
import Util.HibernateUtil;
import org.hibernate.HibernateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class AppMainTest {
    Task hometask;
    Task workTask;
    Task task;

    @Before
    public void beforeTest() {
        hometask = HomeTask.builder()
                .name("hometest3")
                .description("home_desc3")
                .startDate(LocalDate.of(2022, 03, 03))
                .endDate(LocalDate.of(2022, 04, 04))
                .executor(new Person("Oksana", "Kretova"))
                .supervisor(new Person("Olga", "Makarova"))
                .build();
        workTask = WorkTask.builder()
                .name("worktest3")
                .description("work_desc3")
                .cost(25)
                .build();
        task = Task.builder()
                .name("task3")
                .description("task_desc3")
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

    }

    @Test
    public void addTaskTest(){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(task);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            entityManager.getTransaction().rollback();
        }
        entityManager.getTransaction().begin();
        Task taskFromBase = entityManager.find(Task.class,task.getId());
        Assert.assertEquals(taskFromBase,task);
        Assert.assertEquals(taskFromBase.getId(),task.getId());
        Assert.assertEquals(taskFromBase.getName(),task.getName());
        Assert.assertEquals(taskFromBase.getDescription(),task.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
