import DBO.Address;
import DBO.HomeTask;
import DBO.Task;
import DBO.WorkTask;
import HibernateUtil.HibernateEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

public class LaunchMain {
//
//    @PersistenceContext(unitName = "item-manager-pu")
//    protected static EntityManager entityManager;


    public static void main(String[] args) {

        Address address = new Address();
        HomeTask homeTask = new HomeTask();

        homeTask.setAddress(address);
        homeTask.setStartDate(new Date());
        homeTask.setEndDate(new Date());

        homeTask.setName("Илья");
        homeTask.setDescription("Вопросы по работе");
        address.setCity("Нью-йорк");
        address.setStreet("Ленина");

        WorkTask workTask = new WorkTask();
        workTask.setCost(2.69);
        workTask.setDescription("Личные вопросы");
        workTask.setName("Инга");

        EntityManager entityManager = HibernateEntityManager.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(homeTask);
        entityManager.persist(workTask);

        entityManager.getTransaction().commit();
        entityManager.close();
        listTask();

    }

    public static void listTask() {
        EntityManager entityManager = HibernateEntityManager.getEntityManager();
        entityManager.getTransaction().begin();
        List<Task> tasks = entityManager.createQuery("from Task", Task.class).getResultList();
        for (Task task1 : tasks) {
            System.out.println(task1);
        }
    }
}
