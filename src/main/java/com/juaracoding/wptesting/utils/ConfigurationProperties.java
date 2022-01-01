package com.juaracoding.wptesting.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.txt")
public class ConfigurationProperties {

	@Value("${browser}")
	private String browser;
	
	@Value("${myusername}")
	private String txtRegUsername;
	
	@Value("${email}")
	private String txtRegEmail;
	
	@Value("${password}")
	private String  txtRegPassword;
	
	@Value("${loginmessage}")
	private String txtLoginMessage;
	
	@Value("${txtmyaccount}")
	private String txtMyAccount;
	
	@Value("${addtocartshoes}")
	private String addToCartShoes;
	
	@Value("${addtocartglass}")
	private String addToCartGlass;
	
//	@Value("${txtdashboard}")
//	private String txtDashboard;

	public String getBrowser() {
		return browser;
	}

	public String getUserName() {
		return txtRegUsername;
	}

	public String getEmail() {
		return txtRegEmail;
	}

	public String getPassword() {
		return txtRegPassword;
	}

	public String getTxtLoginMessage() {
		return txtLoginMessage;
	}
	
	public String getTxtMyAccount() {
		return txtMyAccount;
	}
	
	public String getAddToCartShoes() {
		return addToCartShoes;
	}
	
	public String getAddToCartGlass() {
		return addToCartGlass;
	}
//	public String getTxtDashboard() {
//		return txtDashboard;
//	}
	
}
