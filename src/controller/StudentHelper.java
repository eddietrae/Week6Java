/**
 * @author Trae Eddie - tmeddie
 * CIS175 - Spring 2021
 * Feb 11, 2021
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Student;

/**
 * @author Traee
 *
 */
public class StudentHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAEddie"); 
	public void insertItem(Student stu) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(stu);
		em.getTransaction().commit();
		em.close();
	}
	public List<Student> showAllStudents(){
		EntityManager em = emfactory.createEntityManager();
		List<Student> allStudents = em.createQuery("SELECT s FROM Student s").getResultList();
		return allStudents;
	}
	public void deleteItem(Student toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select stu from Student stu where stu.name = :selectedName and stu.age = :selectedAge", Student.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAge", toDelete.getAge());

		//we only want one result
		typedQuery.setMaxResults(1);

		//get the result and save it into a new list item
		Student result = typedQuery.getSingleResult();

		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	/**
	 * @param toEdit
	 */
	public void updateItem(Student toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();

	}
	public Student searchForStudentById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Student found = em.find(Student.class, idToEdit);
		em.close();
		return found;

	}
	
	public List<Student> searchForStudentByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Student> typedQuery = em.createQuery("select s from Student s where s.name = :selectedName", Student.class);
		typedQuery.setParameter("selectedName", name);

		List<Student> foundStudents = typedQuery.getResultList();
		em.close();
		return foundStudents;

	}
	
	public List<Student> searchForStudentByAge(int age) {
		// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<Student> typedQuery = em.createQuery("select s from Student s where s.age = :selectedAge", Student.class);
			typedQuery.setParameter("selectedAge", age);

			List<Student> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
	}
	public void cleanUp(){
		emfactory.close();
	}
}
