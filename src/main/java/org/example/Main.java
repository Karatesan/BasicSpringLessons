package org.example;

import org.example.config.AppConfig;
import org.example.model.MyUser;
import org.example.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        String[] beanNames = context.getBeanDefinitionNames();
//        System.out.println("Beans in Spring Context:");
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

        UserService userService = context.getBean(UserService.class);
        MyUser user = new MyUser();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        userService.saveUser(user);

        MyUser retrievedUser = userService.findUserByName("John Doe");
        System.out.println("===================================");
        System.out.println("Retrieved User: " + retrievedUser.getName() + ", Email: " + retrievedUser.getEmail());

    context.close();

    }
}