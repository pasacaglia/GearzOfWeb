package com.web.gearz.models;

import java.util.ArrayList;
import java.util.List;

public class Template {
	
	private int id;
	private String name;
	private List<String> divIds = new ArrayList<String>();
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
	public void setDivIds(List<String> divIds) {
		this.divIds = divIds;
	}
	public List<String> getDivIds() {
		return divIds;
	}

}
