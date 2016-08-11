package com.igitras.demo.gateway.service;

import com.igitras.demo.gateway.web.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mason on 8/12/16.
 */
@FeignClient(name = "backend1",
             url = "http://localhost:19101/")
public interface Backend1PersonService {

    @RequestMapping(value = "persons/{name}")
    Person find(@PathVariable("name") String name);
}
