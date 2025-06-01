package com.productor.test;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import com.alibaba.cloud.nacos.discovery.NacosServiceDiscovery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoverTest {
    @Autowired private DiscoveryClient discoveryClient;

    @Autowired private NacosDiscoveryClient nacosDiscoveryClient;

    //原生
    @Autowired private NacosServiceDiscovery nacosServiceDiscovery;

    @Test
    public void discover(){
        System.out.println(discoveryClient.description());
        System.out.println(discoveryClient.getOrder());
        for (String service : discoveryClient.getServices()){
            System.out.println("service : "+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            System.out.println("len instances : "+instances.size());
            ServiceInstance instance = instances.get(0);
            System.out.println(instance.getInstanceId());
            System.out.println(instance.getHost());
            System.out.println(instance.getPort());
            System.out.println(instance.getMetadata());
            System.out.println(instance.getUri());
            System.out.println(instance.getScheme());
            System.out.println(instance.getServiceId());
            System.out.println("----------------------------------------");
        }
    }
}
