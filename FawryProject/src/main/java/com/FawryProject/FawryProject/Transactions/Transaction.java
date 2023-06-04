package com.FawryProject.FawryProject.Transactions;

import com.FawryProject.FawryProject.Service.Services;

public class Transaction 
{
	public int id;
	public Services s;
	public double amount;
	public int UID;
	
	public String toString()
	{
		return "ID: "+id+" Service: "+s.CName+" Service Provider:" + s.SName + " Amount: "+ amount;
	}
	
	public String toStringUID()
	{
		return "ID: "+id+" Service: "+s.CName+" Service Provider:" + s.SName 
				+" User ID "+ UID+ " Amount: "+ amount;
	}
}
