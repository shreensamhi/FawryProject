package com.FawryProject.FawryProject.Service;

import java.sql.SQLException;

public class Vodafone extends Services {

	public Vodafone() throws SQLException
	{
		SName = "Vodafone";
		nOfFields = 3;
		
		form = new String[nOfFields];
		formHandler = new String[nOfFields];
		form[0]="Enter the amount";
		form[1]="Enter the Payment option";
		form[2]="Enter the phone number";
	}
}
