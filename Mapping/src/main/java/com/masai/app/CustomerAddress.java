package com.masai.app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.masai.app.entity.Address;
import com.masai.app.entity.Customer;
import com.masai.app.util.EMUtils;

public class CustomerAddress {

	public static void main(String[] args) {
		EntityManager em = EMUtils.provideEntityManager();
		Address a1 = new Address(0,"Tamil Nadu", "Chennai", "600090");
		Address a2 = new Address(0,"Tamil Nadu", "Chennai", "600090");
		Customer c1 = new Customer();
		c1.setName("Vaibhav");
		c1.setEmail("vaibhavkarthikeyan@gmail.com");
		c1.setMobileNumber("8754159553");
		c1.getAddresses().add(a1);
		c1.getAddresses().add(a2);
		Address a3 = new Address(0,"Karnataka", "Banglore", "560006");
		Address a4 = new Address(0,"Karnataka", "Banglore", "560008");
		Customer c2 = new Customer();
		c2.setName("Ram");
		c2.setEmail("ram@gmail.com");
		c2.setMobileNumber("9876543210");
		c2.getAddresses().add(a3);
		c2.getAddresses().add(a4);

		em.getTransaction().begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(c1);
		em.persist(a3);
		em.persist(a4);
		em.persist(c2);
		em.getTransaction().commit();
		String jpql = "select addresses from Customer where cid='3'";
		Query q = em.createQuery(jpql);

		List<Address> address = q.getResultList();

		em.close();
		
		System.out.println(address);
	}

}
