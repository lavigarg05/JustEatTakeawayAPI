package com.jet.framework.base;

public enum APIResources {
	AddNewPostAPI("/posts"),
	GetPostAPI("/posts/{id}"),
	GetAllPostsAPI("/posts"),
	GetPostCommentsAPI("/posts/{id}/comments"),
	GetCommentsAPI("/comments");
	
	
	private String resource;
	
	APIResources(String resource) {
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
