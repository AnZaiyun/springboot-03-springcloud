package com.anzaiyun.ConsumerOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerOrderHyDsbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrderHyDsbApplication.class,args);
    }
}
