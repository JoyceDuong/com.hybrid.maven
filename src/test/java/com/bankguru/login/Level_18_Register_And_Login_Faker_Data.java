package com.bankguru.login;

import Utilities.FakerUtil;

public class Level_18_Register_And_Login_Faker_Data  {
	FakerUtil fakerData;
	
	
	public void main () {
		fakerData = FakerUtil.getData();
		
		fakerData.getFirstName();
		fakerData.getLastName();
		fakerData.getFullName();
		
		
	}

}
