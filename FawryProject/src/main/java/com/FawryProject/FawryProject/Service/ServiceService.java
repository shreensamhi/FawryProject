package com.FawryProject.FawryProject.Service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.FawryProject.FawryProject.Customer.Customer;

@Service
public class ServiceService 
{
	ServiceDataAccess SDA =new ServiceDataAccess();
	
	protected List<String> Search(String str) throws SQLException
	{
		
		return SDA.Search(str);
	}

	
	public List<String> checkDiscounts() throws SQLException
	{	
        return SDA.checkDiscounts();
	}


	public List<String> ViewServices() throws SQLException
	{	
        return SDA.Search("");
	}

	
	public Services getService(Services s) throws SQLException
	{
		if(s.CName==null || s.SName ==null)
		{
			return null;
		}
		
		
		switch(s.SName)
		{
		case "Vodafone":
		{
			if(s.CName.equals("Mobile"))
			{
				s = new Vodafone(); 
				s.CName = "Mobile";
			}
			else
			{
				s = new Vodafone(); 
				s.CName = "Internet";
			}
			break;
		}
		
		case "Etisalat":
		{
			if(s.CName.equals("Mobile"))
			{
				s = new Etisalat(); 
				s.CName = "Mobile";
			}
			else
			{
				s = new Etisalat(); 
				s.CName = "Internet";
			}
			break;
		}
		case "Orange":
		{
			if(s.CName.equals("Mobile"))
			{
				s = new Orange(); 
				s.CName = "Mobile";
			}
			else
			{
				s = new Orange(); 
				s.CName = "Internet";
			}
			break;
		}
		case "We":
		{
			if(s.CName.equals("Mobile"))
			{
				s = new We(); 
				s.CName = "Mobile";
			}
			else
			{
				s = new We(); 
				s.CName = "Internet";
			}
			break;
		}
		case "MonthlyReceipt":
		{
			s = new MonthlyReceipt(); 
			s.CName = "Landline";
			break;
		}
		case "QuarterReceipt":
		{
			s = new QuarterReceipt(); 
			s.CName = "Landline";
			break;
		}
		case "Hospitals":
		{
			s = new Hospitals(); 
			s.CName = "Donations";
			break;
		}
		case "Schools":
		{
			s = new Schools(); 
			s.CName = "Donations";
			break;
		}
		case "NGOs":
		{
			s = new NGOs(); 
			s.CName = "Donations";
			break;
		}
		
		}
		return s;
	}
	
	
	public String pay(Services serv2) throws NumberFormatException, SQLException
	{
		Services serv = new Services();
		double amount = 0;
		String res = "";
		if(!Customer.loggedIn)
		{
			return "Please Sign In First";
		}
		else
		{
			if(serv2.CName==null)
			{
				return "Please choose the service";
			}
			else if(serv2.SName==null)
			{
				return "Please choose the Service provider";
			}
			
			
			serv.CName=serv2.CName;
			serv.SName=serv2.SName;
			
			
			serv = getService(serv);
			serv = SDA.getDiscounts(serv);
			
			serv.formHandler=serv2.formHandler;
			
			if(serv.formHandler[0]==null || Double.parseDouble(serv.formHandler[0])<=0)
			{
				return "Please Enter the amount you are willing to pay";
			}
			else if(serv.formHandler[1]==null || (!serv.formHandler[1].equals("Cash") && !serv.formHandler[1].equals("Credit")  && !serv.formHandler[1].equals("Wallet")))
			{
				return "Please Enter the payment option";
			}
			boolean flag = true;
			
			for(int i=0; i<serv.nOfFields; i++)
			{
				if(serv.formHandler[i]==null)
				{
					flag = false;
					break;
				}
			}
			if(!flag)
			{
				return "Please fill all form queries";
			}
			else
			{
				amount=Double.parseDouble(serv.formHandler[0]);
				if (serv.HasDiscount)
				{
					amount = amount - (serv.d*amount)/100;
					res = "You have "+serv.d+"% discount, you'll only pay "+amount+"\n";
				}
				if(SDA.getOverallDiscount()!=0 && Customer.nOfTransactions==0)
				{
					amount = amount - (SDA.getOverallDiscount()*Double.parseDouble(serv.formHandler[0]))/100;
					res += "You have "+SDA.getOverallDiscount()+"% overall discount, you'll only pay "+amount+"\n";
				}
				
				
				if(serv.formHandler[1].equals("Cash") || serv.formHandler[1].equals("Credit"))
				{
					SDA.MakeTransaction(serv,amount);
					 Customer.nOfTransactions++;
					 res+="Transaction Done";
					return res;
				}
				else
				{
					if(Customer.w.Pay(Double.parseDouble(serv.formHandler[0])))
					{
						SDA.MakeTransaction(serv,amount);
						Customer.nOfTransactions++;
						res+="Transaction Done";
						return res;
					}
					else
					{
						return "Balance isn't enough";
					}
				}
			}
			
		}
	}

	
	public String addSpecificDiscout(Services s) throws SQLException
	{
		if(s.d<0)
		{
			return "Please enter the discount amount";
		}
		
		SDA.AddSpecificDiscount(s);

		return "Discount added Successfully";
	}
	public String AddOverallDiscount(int d) throws SQLException
	{
		if(d<0)
		{
			return "Please enter the discount amount";
		}
		
		SDA.AddOverallDiscount(d);
		
		return "Discount added Successfully";
	}
	
}
