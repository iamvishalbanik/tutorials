package com.cg.chocolateservice;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.cg.chocolatedao.ChocolateDAOImpl;
import com.cg.chocolatedao.ChocolateDAOLayer;
import com.cg.chocolatedto.Chocolate;

//@Component
@Service

public class ChocolateServiceImpl {
	//implements ChocolateServicesLayer{

	@Autowired
	private ChocolateDAOLayer dao;
	
	@Transactional
	public int addChocolateService(Chocolate chocolate) {
		int result = dao.addChocolate(chocolate);
		return result;
	}
	@Transactional(readOnly=true)
	public Chocolate viewChocolateService(int chocolate_id) {
		Chocolate chocolate = dao.viewChocolate(chocolate_id);
		return chocolate;
	}
	@Transactional
	public int deleteChocolateService(int chocolate_id) {
		int result = dao.deleteChocolate(chocolate_id);
		return result;
	}
	@Transactional
	public int updateChocolateService(int chocolate_id,int chocolate_price) {
		int result = dao.updateChocolate(chocolate_id,chocolate_price);
		return result;
	}
	@Transactional(readOnly=true)
	public List<Chocolate> viewAllChocolate() {
		List<Chocolate> result = dao.viewAllChocolate();
		return result;
	}

}
