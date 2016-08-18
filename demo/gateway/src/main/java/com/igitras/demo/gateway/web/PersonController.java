package com.igitras.demo.gateway.web;

import com.igitras.demo.gateway.service.Backend1PersonService;
import com.igitras.demo.gateway.service.Backend2PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by mason on 8/12/16.
 */
@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private Backend1PersonService backend1PersonService;

    @Autowired
    private Backend2PersonService backend2PersonService;

    @RequestMapping(method = RequestMethod.GET, value = "{name}")
    public List<Person> find(@PathVariable("name") String name) {
        List<Person> persons = new ArrayList<>();
        Person person = backend1PersonService.find(name);
        if (person != null) {
            persons.add(person);
        }
        person = backend2PersonService.find(name);
        if (person != null) {
            persons.add(person);
        }
        return persons;
    }


    @RequestMapping(method = RequestMethod.GET)
    public Collection<Person> search() {
        List<Person> persons = new ArrayList<>();
        Collection<Person> person = backend1PersonService.search();
        if (person != null) {
            persons.addAll(person);
        }
        person = backend2PersonService.search();
        if (person != null) {
            persons.addAll(person);
        }
        return persons;
    }
}
