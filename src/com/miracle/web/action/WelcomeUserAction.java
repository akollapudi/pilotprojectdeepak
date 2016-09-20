package com.miracle.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.miracle.service.restclient.ConnectRestService;

public class WelcomeUserAction {

	private String username;
	private String password;
	private String message;
	private List<String> orgNames= new ArrayList<String>();

	public List<String> getOrgNames() {
		return orgNames;
	}

	public void setOrgNames(List<String> orgNames) {
		this.orgNames = orgNames;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	ConnectRestService info = null;
	public String execute() {
		if(username.equals("Miracle")){
			
			info = new ConnectRestService();
			String outputresult = info.getCustomerVendorList();
			String[] name=outputresult.split("");
			StringTokenizer sb=new StringTokenizer(outputresult,"|");			
			while (sb.hasMoreElements()) {
				String s= (String) sb.nextElement();
				String alphaOnly = s.replaceAll("[^\\p{Alpha}]+","");				
				orgNames.add(alphaOnly);
			}
			message= "SUCCESS";
		}
		else{
			message= "FAIL";
			}
		return message;
	}

}