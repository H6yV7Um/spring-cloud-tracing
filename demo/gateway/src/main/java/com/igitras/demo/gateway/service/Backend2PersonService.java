package com.igitras.demo.gateway.service;

import com.igitras.demo.gateway.web.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Created by mason on 8/12/16.
 */
@FeignClient(name = "backend2", url="http://localhost:19102/")
public interface Backend2PersonService {

    @RequestMapping(value = "persons/{name}")
    Person find(@PathVariable("name") String name);

    @RequestMapping(value = "persons")
    Collection<Person> search();
}
