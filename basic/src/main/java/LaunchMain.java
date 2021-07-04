import DBO.Address;
import DBO.HomeTask;
import DBO.Task;
import HibernateUtil.HibernateEntityManager;

import javax.persistence.EntityManager;
import java.util.Date;

public class LaunchMain {
    public static void main(String[] args) {

        Task task = new Task();
        Address address = new Address();
        HomeTask homeTask = new HomeTask();

        homeTask.setAddress(address);
        homeTask.setStartDate(new Date());
        homeTask.setEndDate(new Date());

        task.setName("Илья");
        task.setDescription("Вопросы по работе");
        address.setCity("Нью-йорк");
        address.setStreet("Ленина");

        EntityManager entityManager = HibernateEntityManager.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(homeTask);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
