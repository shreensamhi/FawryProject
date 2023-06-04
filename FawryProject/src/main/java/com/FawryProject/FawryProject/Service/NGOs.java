package com.FawryProject.FawryProject.Service;
public class NGOs extends Services
{
	NGOs()
	{
		SName = "NGOs";
	
		
		nOfFields = 3;
		
		form = new String[nOfFields];
		formHandler = new String[nOfFields];
		form[0]="Enter the amount";
		form[1]="Enter the Payment option";
		form[2]="Enter the name of the organization";
	}
}
