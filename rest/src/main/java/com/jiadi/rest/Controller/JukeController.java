package com.jiadi.rest.Controller;

import com.jiadi.rest.Model.Component;
import com.jiadi.rest.Model.Juke;
import com.jiadi.rest.Model.Setting;
import com.jiadi.rest.Model.Setting__1;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
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

    @RequestMapping("/jukes/settingid/{settingId}")
    public List<Juke> getJukeBySettingId(@PathVariable("settingId") String settingId){
        List<Juke> jukes = getAllJukes();
        Setting settings = getAllSettings();

        List<Juke> jukesFound = new ArrayList<>();
        

        return jukesFound;
    }

    @RequestMapping("/jukes/id/{id}")
    public Juke getJukeById(@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();

        Juke juke = restTemplate.getForObject(uriJuke + id, Juke.class);
        return juke;
    }



    @RequestMapping("/jukes/model/{model}")
    public Juke getJukeByModel(@PathVariable("model") String model){
        RestTemplate restTemplate = new RestTemplate();

        Juke[] jukes = restTemplate.getForObject(uriJuke, Juke[].class);
        for (int i = 0; i< jukes.length;i++){
            if (jukes[i].getModel().equals(model)){
                return jukes[i];
            }
        }

        return null;
    }

    @RequestMapping("/settings")
    public Setting getAllSettings(){

        RestTemplate restTemplate = new RestTemplate();

        Setting settings = restTemplate.getForObject(uriSetting, Setting.class);
        return settings;
    }

    @RequestMapping("/settings/id/{id}")
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

