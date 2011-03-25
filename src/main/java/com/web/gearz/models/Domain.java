package com.web.gearz.models;

public class Domain {
	private int id;
	private User user;
	private Template template;
	private String domainName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getDomainName() {
		return domainName;
	}

}
