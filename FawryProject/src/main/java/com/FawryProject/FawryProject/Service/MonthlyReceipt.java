package com.FawryProject.FawryProject.Service;

public class MonthlyReceipt extends Services
{
	MonthlyReceipt()
	{
		SName = "MonthlyReceipt";
		
		nOfFields = 4;
		
		form = new String[nOfFields];
		formHandler = new String[nOfFields];
		form[0]="Enter the amount";
		form[1]="Enter the Payment option";
		form[2]="Enter the landline number";
		form[3]="Enter your zip code";
	}

}
