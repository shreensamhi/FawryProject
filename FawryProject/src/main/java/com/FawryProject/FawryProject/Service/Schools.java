package com.FawryProject.FawryProject.Service;
public class Schools extends Services
{
	Schools()
	{
		SName = "Schools";
		
		
		nOfFields = 3;
		
		form = new String[nOfFields];
		formHandler = new String[nOfFields];
		form[0]="Enter the amount";
		form[1]="Enter the Payment option";
		form[2]="Enter the name of the school";
	}
}
