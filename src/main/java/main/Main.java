package main;

import java.util.ArrayList;
import java.util.List;
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

		final CarProgrammatic car101 = new CarProgrammatic("black");
		final CarProgrammatic car102 = new CarProgrammatic("white");
		final CarProgrammatic car103 = new CarProgrammatic("red");
		final CarProgrammatic car104 = new CarProgrammatic("yellow");

		List<CarProgrammatic> cars = new ArrayList<CarProgrammatic>();
		cars.add(car101);
		cars.add(car102);
		cars.add(car103);
		cars.add(car104);

		for(CarProgrammatic car:cars)
		{
			
		}
		
//		Supplier<CarProgrammatic> carSupplier = new Supplier<CarProgrammatic>() {
//			@Override
//			public CarProgrammatic get() {
//				return car;
//			}
//		};
//		Supplier<CarProgrammatic> carSupplierLambda = () -> car;

		//		//Lambda with anonymous class
		//		Supplier<List<CarProgrammatic>> carSupplier = new Supplier<List<CarProgrammatic>>() {
		//			@Override
		//			public List<CarProgrammatic> get() {
		//				return cars;
		//			}
		//		};
		//		//Lambda
		//		Supplier<List<CarProgrammatic>> carSupplierLambda = () -> cars;

		programmaticContext.registerBean("car", CarProgrammatic.class, carSupplierLambda, (BeanDefinition bd)-> bd.setPrimary(true));
		CarProgrammatic carBean = programmaticContext.getBean("car",CarProgrammatic.class);
		System.out.println(carBean.getColor());



	}

}
