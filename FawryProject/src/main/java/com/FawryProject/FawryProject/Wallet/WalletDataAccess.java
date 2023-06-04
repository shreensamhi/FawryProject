package com.FawryProject.FawryProject.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.FawryProject.FawryProject.DatabaseConnection;
import com.FawryProject.FawryProject.Customer.Customer;

public class WalletDataAccess 
{
	protected DatabaseConnection connection = new DatabaseConnection();
	protected Connection con ;
	protected String query;
	protected PreparedStatement ps;
	
	protected void Addfunds(double Amount) throws SQLException
	{
		con = connection.connect();
		Customer.w.balance += Amount;
		
		query = "update UserAccounts "
				+ "set walletbalance = "+ Customer.w.balance 
				+ "where ID = "+ Customer.id + ';' ;
		ps = con.prepareStatement(query);
		ps.executeUpdate();
		
		
		con.close();
	}

}
