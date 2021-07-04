import DBO.Address;
import DBO.HomeTask;
import DBO.Task;
import DBO.WorkTask;
import HibernateUtil.HibernateEntityManager;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Locale;

public class LaunchMain {
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

        WorkTask workTask= new WorkTask();
        workTask.setCost(2.57);
        workTask.setName("Андрей");
        workTask.setDescription("Личные вопросы");

        EntityManager entityManager = HibernateEntityManager.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(homeTask);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.persist(workTask);
        entityManager.getTransaction().commit();
        entityManager.close();

        //entityManager.close();
        // entityManager.close();

    }
}
