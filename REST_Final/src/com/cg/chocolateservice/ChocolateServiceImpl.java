package com.cg.chocolateservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.chocolatedao.ChocolateDAOImpl;
import com.cg.chocolatedao.ChocolateDAOLayer;
import com.cg.chocolatedto.Chocolate;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ChocolateServiceImpl {
	@Autowired
	private ChocolateDAOImpl dao;
	
	//@Transactional
	public int addChocolateService(Chocolate chocolate) {
		int result = dao.addChocolate(chocolate);
		return result;
	}
	//@Transactional(readOnly=true)
	public Chocolate viewChocolateService(int chocolate_id) {
		Chocolate chocolate = dao.viewChocolate(chocolate_id);
		return chocolate;
	}
	//@Transactional
	public int deleteChocolateService(int chocolate_id) {
		int result = dao.deleteChocolate(chocolate_id);
		return result;
	}
	//@Transactional
	public int updateChocolateService(Chocolate chocolate) {
		int result = dao.updateChocolate(chocolate);
		return result;
	}
	//@Transactional(readOnly=true)
	public List<Chocolate> viewAllChocolate() {
		List<Chocolate> result = dao.viewAllChocolate();
		return result;
	}

}
