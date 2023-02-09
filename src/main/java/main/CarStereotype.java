package main;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class CarStereotype {

	private String color;
	
	@PostConstruct
	public void init() {
		this.color = "black";
	}
	
	public String getColor() {
		return color;
	}

	public void setName(String color) {
		this.color = color;
	}
	
}
