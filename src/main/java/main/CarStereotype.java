package main;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class CarStereotype {

	private String color;
	private String name;
	
	@PostConstruct
	public void init() {
		this.color = "black";
		this.name = "Audi";
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
