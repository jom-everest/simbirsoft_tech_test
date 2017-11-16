package com.simbirsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author slava
 * 
 */

@SpringBootApplication
public class Application {

    /**
     * @param args аргумент 
     */
    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {Application.class}, args);
    }
}
