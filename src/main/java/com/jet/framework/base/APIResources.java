package com.jet.framework.base;

public enum APIResources {
	AddNewPostAPI("/posts"),
	GetPostAPI("posts/{id}"),
	GetPostCommentsAPI("posts/{id}/comments");
	
	
	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
