package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import main.Car;

@Configuration  
public class ProjectConfig {

	@Primary 
	@Bean(name="car1") 
	Car car1() { 
		Car car = new Car();
		car.setColor("Black");
		return car;
	}
	@Bean(name="car2")
	Car car2() { 
		Car car = new Car();
		car.setColor("Red");
		return car;
	}
	@Bean(name="car3") 
	Car car3() { 
		Car car = new Car();
		car.setColor("Yellow");
		return car;
	}
}
