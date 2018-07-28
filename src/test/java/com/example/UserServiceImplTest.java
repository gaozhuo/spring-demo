package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    private ApplicationContext context;
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        userService = (UserService) context.getBean("userService");
    }

    @Test
    public void add() {
        userService.add();
    }

    @Test
    public void update() {
        userService.update(10);
    }

    @Test
    public void delete() {
        userService.delete();
    }

    @Test
    public void search() {
        userService.search();
    }
}