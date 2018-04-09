package genus.panthera.car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Rally {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("car.context.xml");
        Car honda = context.getBean("honda", Car.class);
        Car suzuki = context.getBean("suzuki", Car.class);
        honda.speedup().speedup().speedup().speedup().speedup();
        System.out.println(honda);
        System.out.println(suzuki);

    }
}

