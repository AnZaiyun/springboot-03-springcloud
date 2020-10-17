package com.anzaiyun.ProviderPayment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.anzaiyun.ProviderPayment.mapper")
@EnableCircuitBreaker
public class ProviderPaymentHY8010Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentHY8010Application.class,args);
    }

    /**
     * 这一段没明白是什么意思？？？
     * 此配置是为了监控服务而配置，与服务容错本身无关
     * ServletRegistrationBean因为springboot的默认路径不是“hystrix.stream”
     * 所以需要在自己的项目里配置上HystrixMetricsStreamServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
