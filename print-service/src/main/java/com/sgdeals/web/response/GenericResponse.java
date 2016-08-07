package com.sgdeals.web.response;

public class GenericResponse {

	private String text;
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	
	private GenericResponse(){}
	private GenericResponse(String text){ this.text = text;}
	
	public static GenericResponse generate(String text){
		return new GenericResponse(text);
	}
	
	
}
