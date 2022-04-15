package com.jiadi.rest.Controller;

import com.jiadi.rest.Model.Juke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class JukeController {

    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(){
        return "lol";
    }

    @RequestMapping("/")
    public void getAllJukes(){
        String url = "https://my-json-server.typicode.com/touchtunes/tech-assignment/jukes";
        RestTemplate restTemplate = new RestTemplate();

        Juke[] jukes = restTemplate.getForObject(url, Juke[].class);
        System.out.println(jukes);
    }

//    @RequestMapping("/{id}")
//    public Juke getJukes(@PathVariable("id") long id){
//        Juke juke = restTemplate.getForObject(
//                "http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes" + id,
//                Juke.class
//        );
//        return new Juke(id,juke.getModel(),juke.getComponants());
    }

