package SpringCore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class App {

    public static void main(String[] args) {

        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));

//        ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");
        Alien obj = (Alien) factory.getBean("alien");
        obj.code();
        System.out.println(obj.getAge()+" obj hashcode: "+obj.hashCode());
        Alien obj1 = (Alien) factory.getBean("alien");
        obj1.code();
        System.out.println(obj1.getAge()+" obj hashcode: "+obj1.hashCode());
    }
}
