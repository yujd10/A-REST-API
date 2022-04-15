package com.jiadi.rest.Controller;

import com.jiadi.rest.Model.Juke;
import com.jiadi.rest.Model.Setting;
import com.jiadi.rest.Model.Setting__1;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
public class JukeController {

//    @Autowired
    String uriJuke = "https://my-json-server.typicode.com/touchtunes/tech-assignment/jukes/";
    String uriSetting = "https://my-json-server.typicode.com/touchtunes/tech-assignment/settings/";

    @GetMapping("/jukes/hello")
    public String hello(){
        return "lol";
    }

    @RequestMapping("/jukes")
    public List<Juke> getAllJukes(){

        RestTemplate restTemplate = new RestTemplate();

        Juke[] jukes = restTemplate.getForObject(uriJuke, Juke[].class);
        return Arrays.asList(jukes);
    }

    @RequestMapping("/jukes/{id}")
    public Juke getJukeById(@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();

        Juke juke = restTemplate.getForObject(uriJuke + id, Juke.class);
        return juke;
    }

    @RequestMapping("/settings")
    public List<Setting> getAllSettings(){

        RestTemplate restTemplate = new RestTemplate();

        Setting settings = restTemplate.getForObject(uriSetting, Setting.class);
        return Arrays.asList(settings);
    }

    @RequestMapping("/settings/{id}")
    public Setting__1 getSettingById(@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();

        Setting settings = restTemplate.getForObject(uriSetting, Setting.class);
        for (int i = 0; i< settings.getSettings().size();i++){
            if (settings.getSettings().get(i).getId().equals(id)){
                return settings.getSettings().get(i);
            }
        }

        return null;
    }

    }

