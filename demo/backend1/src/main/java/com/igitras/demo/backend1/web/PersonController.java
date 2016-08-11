package com.igitras.demo.backend1.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

/**
 * Created by mason on 8/12/16.
 */
@RestController
@RequestMapping("persons")
public class PersonController {

    private Map<String, Person> personMap = new HashMap<>();

    @PostConstruct
    public void init() {
        personMap.put("name", new Person().setName("name"));
    }

    @RequestMapping(method = RequestMethod.GET,
                    value = "{name}")
    public Person find(@PathVariable("name") String name) {
        return personMap.get(name);
    }
}
