package com.cg.chocolatecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.chocolatedao.ChocolateDAOImpl;
import com.cg.chocolatedto.Chocolate;
import com.cg.chocolateservice.ChocolateServiceImpl;

@RestController
public class ChocolateController
{
   @Autowired
    private ChocolateServiceImpl chocolateservice;    

    @RequestMapping(value="/add", method=RequestMethod.POST, 
            produces="application/json", consumes="application/json")
    public void addChocolate(@RequestBody Chocolate chocolate)
    {
    	chocolateservice.addChocolateService(chocolate);
    	 
    }

    @RequestMapping(value="//{id}",produces="application/json",
            method=RequestMethod.GET)
    public Chocolate viewChocolate(@PathVariable("id") int id)
    {
        Chocolate chocolate = chocolateservice.viewChocolateService(id);
        return chocolate;
    }
    
   
    @RequestMapping(value="/chocolates",produces="application/json",
            method=RequestMethod.GET)
    public List viewAllChocolate()
    {
        List chocolateList = chocolateservice.viewAllChocolate();
        return chocolateList;
    }
    
   
    @RequestMapping(value="/update", method=RequestMethod.PUT, 
            produces="application/json", consumes="application/json")
    public void updateChocolate(@RequestBody Chocolate chocolate)
    {
    	chocolateservice.updateChocolateService(chocolate);
    }
    
    
    @RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE,
             produces="application/json")
    public void deleteChocolate(@PathVariable("id") int id)
    {
    	chocolateservice.deleteChocolateService(id);
    }
}