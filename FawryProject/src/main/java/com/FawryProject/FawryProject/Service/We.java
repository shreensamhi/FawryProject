package com.FawryProject.FawryProject.Service;
public class We extends Services
{
	We()
	{
		SName = "We";
		
		nOfFields = 3;
		
		form = new String[nOfFields];
		formHandler = new String[nOfFields];
		form[0]="Enter the amount";
		form[1]="Enter the Payment option";
		form[2]="Enter the phone number";
	}

}
