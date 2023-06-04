package com.FawryProject.FawryProject.Service;

public class Services 
{
    public  String SName, CName;
    public  int d;
    public  String form[], formHandler[]; 
    public  int nOfFields;
    public boolean HasDiscount;
    
     
    
    public String toString()
    {
    	return "Service Provider: "+ SName + " Service: "+ CName ;
    }
    
    public String toStringDis()
    {
    	return "Service Provider: "+ SName + " Service: "+ CName + " Discount: "+ d +'%' ;
    }
}
