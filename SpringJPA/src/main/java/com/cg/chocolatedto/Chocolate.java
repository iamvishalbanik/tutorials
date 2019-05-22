package com.cg.chocolatedto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chocolate")
public class Chocolate {
	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY )
	
	private int chocolate_id;
	
	private String chocolate_name;
	
	private String chocolate_description;
	
	private int chocolate_price;
	
	public int getChocolate_id() {
		return chocolate_id;
	}

	public void setChocolate_id(int chocolate_id) {
		this.chocolate_id = chocolate_id;
	}

	public String getChocolate_name() {
		return chocolate_name;
	}

	public void setChocolate_name(String chocolate_name) {
		this.chocolate_name = chocolate_name;
	}

	public String getChocolate_description() {
		return chocolate_description;
	}

	public void setChocolate_description(String chocolate_description) {
		this.chocolate_description = chocolate_description;
	}

	public int getChocolate_price() {
		return chocolate_price;
	}

	public void setChocolate_price(int chocolate_price) {
		this.chocolate_price = chocolate_price;
	}

	public Chocolate() {

	}

	public Chocolate(int chocolate_id, String chocolate_name, String chocolate_description, int chocolate_price) {

		this.chocolate_id = chocolate_id;
		this.chocolate_name = chocolate_name;
		this.chocolate_description = chocolate_description;
		this.chocolate_price = chocolate_price;
	}

}
