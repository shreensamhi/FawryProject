package com.FawryProject.FawryProject.Transactions;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.FawryProject.FawryProject.Customer.Customer;


@Service
public class TransactionService 
{

	Transaction t = new Transaction();
	TransactionDataAccess TDA = new TransactionDataAccess();
	
	public List<String> getTransactions() throws SQLException
	{
		return TDA.getTransactions();
	}
	
	public String askForRefund(int id) throws SQLException
	{
		if(!Customer.loggedIn)
		{
			return "Please log in first";
		}
		
        return TDA.AskForRefund(id);
	}

	public List<String> ViewRefundRequest() throws SQLException
	{	
        return TDA.ViewRefundRequest();
	}
	
	public String AcceptRefundRequest(int id) throws SQLException
	{	
		return TDA.AcceptRefundRequest(id);  
	}
}
