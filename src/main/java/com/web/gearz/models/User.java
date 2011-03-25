package com.web.gearz.models;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String name;
	private List<Domain> domains = new ArrayList<Domain>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}
	public List<Domain> getDomains() {
		return domains;
	}

}
