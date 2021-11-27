//package com.example.fitness_center.flyway;
//
//import org.flywaydb.core.Flyway;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//@WebListener
//public class FlywayListener implements ServletContextListener {
//    public static Flyway flyway;
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        try{
//            flyway=Flyway.configure().dataSource("jdbc:mysql://localhost:3306/fitness_center","user","spring").load();
//            flyway.migrate();
//        }catch (Exception e) {
//            throw new RuntimeException(e.getMessage(), e);
//        }
//
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//
//    }
//}
