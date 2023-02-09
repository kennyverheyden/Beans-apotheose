package main;

import java.util.function.Supplier;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.ProjectConfig;
import configuration.ProjectConfigProgrammatic;
import configuration.ProjectConfigStereotype;

public class Main {

	public static void main(String[] args) {

		// Methode 1
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Car car1 = context.getBean("car1",Car.class); 
		Car car2 = context.getBean("car2",Car.class); 
		Car car3 = context.getBean("car3",Car.class); 
		System.out.println(car1.getColor());
		System.out.println(car2.getColor());
		System.out.println(car3.getColor());

		System.out.println("\n---------------\n");

		// Methode 2
		
		AnnotationConfigApplicationContext contextStereotype = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);
		CarStereotype carStereotype = contextStereotype.getBean(CarStereotype.class);
		System.out.println(carStereotype.getColor());

		System.out.println("\n---------------\n");
		
		// Methode 3
		
		AnnotationConfigApplicationContext programmaticContext = new AnnotationConfigApplicationContext(ProjectConfigProgrammatic.class);
		final CarProgrammatic car = new CarProgrammatic();
		car.setColor("black");
		
		//Lambda with anonymous class
		Supplier<CarProgrammatic> carSupplier = new Supplier<CarProgrammatic>() {
			@Override
			public CarProgrammatic get() {
				return car;
			}
		};
		//Lambda
		Supplier<CarProgrammatic> carSupplierLambda = () -> car;

		programmaticContext.registerBean("car", CarProgrammatic.class, carSupplierLambda, (BeanDefinition bd)-> bd.setPrimary(true));
		CarProgrammatic carBean = programmaticContext.getBean("car",CarProgrammatic.class);
		System.out.println(carBean.getColor());
		
	}

}
