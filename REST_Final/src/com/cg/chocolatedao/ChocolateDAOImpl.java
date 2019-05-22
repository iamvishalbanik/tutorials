package com.cg.chocolatedao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import com.cg.chocolatedto.Chocolate;
//@Service
//@Transactional(propagation = Propagation.REQUIRED)

public class ChocolateDAOImpl implements ChocolateDAOLayer{
	@PersistenceContext
    private EntityManager entityManager;
	@Override
	public int addChocolate(Chocolate chocolate) {
		 entityManager.persist(chocolate);
		 return 1;
	}

	@Override
	public Chocolate viewChocolate(int chocolate_id) {
Chocolate chocolate = entityManager.find(Chocolate.class, chocolate_id);
		
		return chocolate;
	}

	@Override
	public int deleteChocolate(int chocolate_id) {
Chocolate chocolate = entityManager.find(Chocolate.class, chocolate_id);
		
		entityManager.remove(chocolate);
		return 1;
	}

	@Override
public int updateChocolate(Chocolate chocolate) {
		
		entityManager.merge(chocolate);
		return 1;

	}

	@Override
	public List<Chocolate> viewAllChocolate() {
List<Chocolate> list = entityManager.createQuery("select c from Chocolate c").getResultList();
		
		return list;
	}

}
