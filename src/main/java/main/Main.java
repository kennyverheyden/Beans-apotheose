package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import configuration.ProjectConfig;
import configuration.ProjectConfigProgrammatic;
import configuration.ProjectConfigStereotype;

public class Main {

	public static void main(String[] args) {

		// Method 1

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Car car1 = context.getBean("car1",Car.class); 
		Car car2 = context.getBean("car2",Car.class); 
		Car car3 = context.getBean("car3",Car.class); 
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);

		System.out.println("\n---------------\n");

		// Method 2

		AnnotationConfigApplicationContext contextStereotype = new AnnotationConfigApplicationContext(ProjectConfigStereotype.class);
		CarStereotype carStereotype = contextStereotype.getBean(CarStereotype.class);
		System.out.println(carStereotype.getColor());

		System.out.println("\n---------------\n");

		// Method 3

		AnnotationConfigApplicationContext programmaticContext = new AnnotationConfigApplicationContext(ProjectConfigProgrammatic.class);

		final CarProgrammatic car101 = new CarProgrammatic("red","Audi");
		final CarProgrammatic car102 = new CarProgrammatic("white","BMW");
		final CarProgrammatic car103 = new CarProgrammatic("red","Mercedis");
		final CarProgrammatic car104 = new CarProgrammatic("yellow","Porsche");

		List<CarProgrammatic> cars = new ArrayList<CarProgrammatic>();
		cars.add(car101);
		cars.add(car102);
		cars.add(car103);
		cars.add(car104);

		// Bean of object with specific color
		for(CarProgrammatic car:cars)
		{
			if(car.getColor().equals("red"))
			{
				// Lambda with anonymous class
				//				Supplier<CarProgrammatic> carSupplier = new Supplier<CarProgrammatic>() {
				//					@Override
				//					public CarProgrammatic get() {
				//						return car;
				//					}
				//				};
				Supplier<CarProgrammatic> carSupplierLambda = () -> car;

				programmaticContext.registerBean("car"+car, CarProgrammatic.class, carSupplierLambda);
				CarProgrammatic carBean = programmaticContext.getBean("car"+car,CarProgrammatic.class);
				System.out.println(carBean + " is assigned");
			}
		}

	}

}
