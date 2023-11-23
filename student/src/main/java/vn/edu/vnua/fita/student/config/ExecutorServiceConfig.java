package vn.edu.vnua.fita.student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.edu.vnua.fita.student.common.Constants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ExecutorServiceConfig {
    @Bean
    public ExecutorService executor(){
        return Executors.newFixedThreadPool(Constants.ThreadNumber.MAX_THREADS);
    }
}
