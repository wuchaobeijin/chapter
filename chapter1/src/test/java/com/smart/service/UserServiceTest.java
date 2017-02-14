package com.smart.service;

import com.smart.domain.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.beans.Beans;
import java.util.Map;

/**
 * @author : 吴超
 * @date : 2017-02-07
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class UserServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "111111");
        System.out.println(b1 + " ----------");
        System.out.println();
        System.out.println(b2 + " *********** ");
        assert b1 == true;
        assert b2 == false;
    }

    @Test
    public void testSpringIoc() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(Car.class);

        Car car = context.getBean("car1",Car.class);
//        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//        Resource resource = resourcePatternResolver.getResource("applicationContext.xml");
//        BeanFactory beanFactory = new XmlBeanFactory(resource);
        System.out.println("init Beanfactory");
//        Car car = beanFactory.getBean("car1", Car.class);
        System.out.println(car.getBrand() + ", " + car.getMaxSpeed());
        System.out.println("----------");
        for (Object a : car.getFav().keySet()) {
            System.out.println("key : " + a + ", value : " + car.getFav().get(a));
        }
        System.out.println("-----------");
        System.out.println("car bean is ready for use");
    }
}
