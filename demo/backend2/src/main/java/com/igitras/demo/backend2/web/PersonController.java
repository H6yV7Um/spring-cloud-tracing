package com.igitras.demo.backend2.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
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
        personMap.put("name2", new Person().setName("name2"));
    }

    @RequestMapping(method = RequestMethod.GET,
                    value = "{name}")
    public Person find(@PathVariable("name") String name) {
        return personMap.get(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Person> search() {
        return personMap.values();
    }

}
