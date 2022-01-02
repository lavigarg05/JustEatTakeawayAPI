package com.jet.framework.utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.jet.framework.base.Base;
import com.jet.framework.connections.Settings;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils extends Base{
	public static RequestSpecification reqSpec;
	
	public RequestSpecification requestSpecification() throws FileNotFoundException {	
		if(reqSpec==null) {	
			PrintStream log=new PrintStream(new FileOutputStream(Settings.LogPath));
			reqSpec=new RequestSpecBuilder()
					.setBaseUri(Settings.BaseURI)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();	
		}
		return reqSpec;
	}
}
