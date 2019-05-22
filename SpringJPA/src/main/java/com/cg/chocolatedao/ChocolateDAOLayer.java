package com.cg.chocolatedao;

import java.util.List;


import com.cg.chocolatedto.Chocolate;

public interface ChocolateDAOLayer {
	
	public int addChocolate(Chocolate chocolate);

	public Chocolate viewChocolate(int chocolate_id);
	
	public int deleteChocolate(int chocolate_id);
	
	public int updateChocolate(int chocolate_id, int chocolate_price);

	public List<Chocolate> viewAllChocolate();

}
