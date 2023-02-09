package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Stereotype is tweede manier als je niets met de klasse wilt doen

@Configuration
@ComponentScan(basePackages = "main") // Zoek naar klasses geannoteerd met component in package
public class ProjectConfigStereotype {

}
