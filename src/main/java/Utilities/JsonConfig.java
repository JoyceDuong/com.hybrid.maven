package Utilities;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class JsonConfig {
	
	public static JsonConfig getAccountInfor() {
        try {
                         ObjectMapper mapper = new ObjectMapper();
                         mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                         return mapper.readValue(new File(GlobalConstants.PROJECT_PATH+"\\testdata\\Emplyee.json"),JsonConfig.class); // set path and set class name directly
                 } catch (Exception ex) {
                         ex.printStackTrace();
                         return null;
                 }
}
	
	@JsonProperty("email")
	private String email;
	@JsonProperty("password")
	private String password ;
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	
}
