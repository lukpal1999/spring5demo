package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.controllers.ConstructorInjectedController;
import guru.springframework.spring5webapp.controllers.MyController;
import guru.springframework.spring5webapp.controllers.PropertyInjectedController;
import guru.springframework.spring5webapp.controllers.SetterInjectedController;
import guru.springframework.spring5webapp.database.DatabaseSource;
import guru.springframework.spring5webapp.database.JMSSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring5webappApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");
		//controller.hello();
		DatabaseSource databaseSource =  ctx.getBean(DatabaseSource.class);
		JMSSource jmsSource =  ctx.getBean(JMSSource.class);

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(databaseSource.getUserName());
		System.out.println(jmsSource.getUserName());
	}
}
