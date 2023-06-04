package com.FawryProject.FawryProject.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.FawryProject.FawryProject.DatabaseConnection;
import com.FawryProject.FawryProject.Customer.Customer;

public class Wallet 
{
	public double balance;

	protected DatabaseConnection connection = new DatabaseConnection();
	protected Connection con ;
	protected Statement stmt;
	protected String query;
	protected ResultSet r;
	protected PreparedStatement ps;
	
	
	public Wallet(double balance) 
	{
		this.balance=balance;
	}


	public boolean Pay(double a) throws SQLException 
	{
		if(a<=balance)
		{
			con = connection.connect();
			
			balance -= a;
			query = "update UserAccounts "
					+ "set walletbalance = "+ balance 
					+ "where ID = " +Customer.id+ ';' ;
			ps = con.prepareStatement(query);
			ps.executeUpdate();
			con.close();
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
