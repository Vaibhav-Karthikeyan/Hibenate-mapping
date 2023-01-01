package com.masai.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.app.entity.College;
import com.masai.app.entity.Student;
import com.masai.app.util.EMUtils;

public class CollegeStudent {

	public static void main(String[] args) {
		EntityManager em = EMUtils.provideEntityManager();
		College c1 = new College();
		c1.setCollegeAddress("chennai");
		c1.setCollegeName("vit");
		College c2 = new College();
		c2.setCollegeName("vellore");
		c2.setCollegeAddress("vit");
		Student s1 = new Student();
		s1.setStudentName("vaibhav");
		s1.setMobileNumber("9876543210");
		s1.setEmail("vaibhav@gmail.com");
		Student s2 = new Student();
		s2.setStudentName("ram");
		s2.setMobileNumber("9876543210");
		s2.setEmail("2");
		Student s3 = new Student();
		s3.setStudentName("shyam");
		s3.setMobileNumber("9876543210");
		s3.setEmail("3");
		Student s4 = new Student();
		s4.setStudentName("bob");
		s4.setMobileNumber("9876543210");
		s4.setEmail("4");
		Student s5 = new Student();
		s5.setStudentName("job");
		s5.setMobileNumber("9876543210");
		s5.setEmail("5");
		Student s6 = new Student();
		s6.setStudentName("lal");
		s6.setMobileNumber("9876543210");
		s6.setEmail("6");
		Student s7 = new Student();
		s7.setStudentName("raju");
		s7.setMobileNumber("9876543210");
		s7.setEmail("7");
		Student s8 = new Student();
		s8.setStudentName("amy");
		s8.setMobileNumber("9876543210");
		s8.setEmail("8");
		
		s1.setCollege(c1);
		s2.setCollege(c1);
		s3.setCollege(c1);
		s4.setCollege(c1);
		c1.getStudents().add(s1);
		c1.getStudents().add(s2);
		c1.getStudents().add(s3);
		c1.getStudents().add(s4);
		s5.setCollege(c2);
		s6.setCollege(c2);
		s7.setCollege(c2);
		s8.setCollege(c2);
		c2.getStudents().add(s5);
		c2.getStudents().add(s6);
		c2.getStudents().add(s7);
		c2.getStudents().add(s8);
		em.getTransaction().begin();
			em.persist(c1);
			em.persist(c2);
		em.getTransaction().commit();
		
		String jpql1 = "select students from College where collegeid='1'";
		Query q1 = em.createQuery(jpql1);

		List<Student> stu = q1.getResultList();
		
		String jpql2 = "select college from Student where studentRoll='2'";
		Query q2 = em.createQuery(jpql2);

		College clg = (College) q2.getSingleResult();

		em.close();
		
		System.out.println(stu);
		
		System.out.println(clg);
	}
}
