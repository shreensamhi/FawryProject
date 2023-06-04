package com.FawryProject.FawryProject.Service;
public class Hospitals extends Services
{

	Hospitals()
	{
		SName = "Hospitals";
		
		nOfFields = 4;
		
		form = new String[nOfFields];
		formHandler = new String[nOfFields];
		form[0]="Enter the amount";
		form[1]="Enter the Payment option";
		form[2]="Enter your phone number";
		form[3]="Enter the name of the hospital";
	}
}
