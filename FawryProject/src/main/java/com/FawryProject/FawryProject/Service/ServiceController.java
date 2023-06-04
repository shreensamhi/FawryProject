package com.FawryProject.FawryProject.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Service")
public class ServiceController 
{
	ServiceService serv;
	
	@Autowired
	public ServiceController(ServiceService serv)
	{
		this.serv=serv;
	}
	
	@GetMapping("/Search/{s}")
	public List<String> Search(@PathVariable String s) throws SQLException
	{
		return serv.Search(s);
	}
	
	@GetMapping("/Discounts")
	public List<String> checkDiscounts() throws SQLException
	{
		return serv.checkDiscounts();
	}
	
	@GetMapping("/viewServices")
	public List<String> ViewServices() throws SQLException
	{
		return serv.ViewServices();
	}
	
	@GetMapping("/GetServices")
	public String[] GetService(@RequestBody Services s) throws SQLException
	{
		return serv.getService(s).form;
	}
	
	@PostMapping("/Pay")
	public String pay(@RequestBody Services s) throws NumberFormatException, SQLException
	{
		return serv.pay(s);
	}
	
	@PostMapping("/AddSpecificDiscount")
	public String AddSpecificDiscount(@RequestBody Services s) throws SQLException
	{
		return serv.addSpecificDiscout(s);
	}
	
	@PostMapping("/AddOverallDiscount/{d}")
	public String AddOverallDiscount(@PathVariable int d) throws SQLException
	{
		return serv.AddOverallDiscount(d);
	}
	
	
	
	
}
