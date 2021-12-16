package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pojo.Student;
import com.util.HibernateUtilConfig;

public class StudentDao {
	public void saveStudent(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(student);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Student> getStudents() {
		try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
			List<Student>	studentList=session.createQuery("from Student", Student.class).list();
			return studentList;
		}
	}

	public void update(Student student) {
		Transaction transaction=null;
		try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "UPDATE Student set firstName = :fname WHERE id = :sid";
			Query query = session.createQuery(hql);
			query.setParameter("fname", student.getFirstName());
			query.setParameter("sid", student.getId());
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
			transaction.commit();
		}
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
	}

	public void deleteStudent(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a student object
            Student student = session.get(Student.class, id);
            if (student != null) {
                String hql = "DELETE FROM Student WHERE id = :studentId";
                Query query = session.createQuery(hql);
                query.setParameter("studentId", id);
                int result = query.executeUpdate();
                System.out.println("Rows affected: " + result);
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	public void insertStudent() {
		Transaction transaction = null;
		try (Session session = HibernateUtilConfig.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			String hql = "INSERT INTO Student (firstName, lastName, email) "
					+ "SELECT firstName, lastName, email FROM Student1";
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
