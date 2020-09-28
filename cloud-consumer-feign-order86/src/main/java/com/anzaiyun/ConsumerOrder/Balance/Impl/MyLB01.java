package com.anzaiyun.ConsumerOrder.Balance.Impl;

import com.anzaiyun.ConsumerOrder.Balance.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB01 implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取下一个要调用服务的id?
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("next is "+next);

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
