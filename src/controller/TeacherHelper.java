/**
 * @author Trae Eddie - tmeddie
 * CIS175 - Spring 2021
 * Mar 4, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Teacher;

/**
 * @author Traee
 *
 */
public class TeacherHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAEddie");
	public void insertTeacher(Teacher s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	public List<Teacher> showAllTeachers() {
		EntityManager em = emfactory.createEntityManager();
		List<Teacher> allTeachers = em.createQuery("SELECT t FROM Teacher t").getResultList();
		return allTeachers;
	}
}
