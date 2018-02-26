package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.controllers.ConstructorInjectedController;
import guru.springframework.spring5webapp.controllers.MyController;
import guru.springframework.spring5webapp.controllers.PropertyInjectedController;
import guru.springframework.spring5webapp.controllers.SetterInjectedController;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		//controller.hello();

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}
}
