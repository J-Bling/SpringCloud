package com.consumer.controller;

import com.bean.Productor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.ServiceInstanceChooser;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/test")
public class ConsumerController {
    @Autowired private DiscoveryClient discoveryClient;
//    @Autowired private LoadBalancerClient loadBalancerClient ;//负载均衡获取客户端
    @Autowired private RestTemplate restTemplate ;
    @Autowired private ServiceInstanceChooser serviceInstanceChooser;


    @Value("${user.name}")
    public String name;
//    @Value("${user.age}")
//    public String age;


    private final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @GetMapping("/random")
    public Productor random(@RequestParam("name") String name){
        List<ServiceInstance> instances =discoveryClient.getInstances("productor");

        if(instances==null || instances.isEmpty()) return null;

        ServiceInstance instance = instances.get(0);

        String host=instance.getHost();
        int port = instance.getPort();

        System.out.println("host is "+host);
        System.out.println("port is "+port);

        String base_url = "http://"+host+":"+port;

        String url = base_url + "/test/random/"+name;

        Productor productor = restTemplate.getForObject(url,Productor.class);

        logger.info("url: {}",url);
        return productor;
    }

    @GetMapping("/randoms")
    public Productor randoms(@RequestParam("name") String name){
        ServiceInstance instance = serviceInstanceChooser.choose("productor");
        if(instance==null) return null;

        String host=instance.getHost();
        int port = instance.getPort();

        System.out.println("host is "+host);
        System.out.println("port is "+port);

        String base_url = "http://"+host+":"+port;

        String url = base_url + "/test/random/"+name;

        Productor productor = restTemplate.getForObject(url,Productor.class);
        logger.info("urls : {}",url);
        return productor;
    }

    @GetMapping("/randomes")
    public Productor randomes(@RequestParam("name") String name){
        return restTemplate.getForObject("http://productor/test/random/"+name,Productor.class);
    }

    @GetMapping("/config")
    public String getConfig(){
        return "name : "+name;
    }
}
