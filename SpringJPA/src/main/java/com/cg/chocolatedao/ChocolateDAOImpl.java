package com.cg.chocolatedao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.chocolatedto.Chocolate;
import com.cg.chocolateexception.ChocolateException;

@Repository
// @Component

public class ChocolateDAOImpl implements ChocolateDAOLayer {
	@PersistenceContext

	private EntityManager em;

	public int addChocolate(Chocolate chocolate) {
		List<Chocolate> list = em.createQuery("select c from Chocolate c").getResultList();
		for (Chocolate choc : list) {
			if (choc.getChocolate_id() == chocolate.getChocolate_id()) {
				throw new ChocolateException("ID already exists");
			}
		}
		em.persist(chocolate);
		return 1;
	}

	public List<Chocolate> viewAllChocolate() {
		List<Chocolate> list = em.createQuery("select c from Chocolate c").getResultList();
		if (list.isEmpty()) {
			throw new ChocolateException("List is empty");
		}
		return list;

	}

	public int deleteChocolate(int chocolate_id) {
		List<Chocolate> list = em.createQuery("select c from Chocolate c").getResultList();
		if (list.isEmpty()) {
			throw new ChocolateException("List is empty");
		}
		Chocolate chocolate = em.find(Chocolate.class, chocolate_id);
		if (chocolate == null) {
			throw new ChocolateException("ID not found");
		}
		em.remove(chocolate);
		return 1;

	}

	public int updateChocolate(int chocolate_id, int chocolate_price) {
		List<Chocolate> list = em.createQuery("select c from Chocolate c").getResultList();
		if (list.isEmpty()) {
			throw new ChocolateException("List is empty");
		}
		Chocolate chocolate = em.find(Chocolate.class, chocolate_id);
		if (chocolate == null) {
			throw new ChocolateException("ID not found");
		}
		chocolate.setChocolate_price(chocolate_price);
		return 1;

	}

	public Chocolate viewChocolate(int chocolate_id) {
		List<Chocolate> list = em.createQuery("select c from Chocolate c").getResultList();
		if (list.isEmpty()) {
			throw new ChocolateException("List is empty");
		}
		Chocolate chocolate = em.find(Chocolate.class, chocolate_id);
		if (chocolate == null) {
			throw new ChocolateException("ID not found");
		}
		return chocolate;

	}

}
