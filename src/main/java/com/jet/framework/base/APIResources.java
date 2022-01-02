package com.jet.framework.base;

public enum APIResources {
	AddPostAPI("/posts");
	
	
	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
