package com.cg.chocolateservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.chocolatedto.Chocolate;
@Service
public interface ChocolateServicesLayer {
	public int addChocolateService(Chocolate chocolate);

	public Chocolate viewChocolateService(int chocolate_id);

	public int deleteChocolateService(int chocolate_id);

	public int updateChocolateService(int chocolate_id,int chocolate_price);

	public List<Chocolate> viewAllChocolate();
}
