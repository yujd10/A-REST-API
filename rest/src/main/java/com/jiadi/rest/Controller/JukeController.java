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
    public JukeController() {
    }

    String uriJuke = "https://my-json-server.typicode.com/touchtunes/tech-assignment/jukes/";
    String uriSetting = "https://my-json-server.typicode.com/touchtunes/tech-assignment/settings/";

    @GetMapping("/hello")
    public String hello(){
        return "hellooo!";
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
        List<String> requires = getSettingById(settingId).getRequires();;
        List<Juke> jukesFound = new ArrayList<>();


        //Check if a juke contains all requires from the setting that is found
        for(Juke juke : jukes){
            List<String> componentName = new ArrayList<>();
            for(Component component : juke.getComponents()){
                componentName.add(component.getName());
            }
            if(componentName.containsAll(requires)){
                jukesFound.add(juke);
            }
        }

        return jukesFound;
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

    @RequestMapping("/jukes/{offset}/{limit}")
    public List<Juke> getJukesOffsetLimit(@PathVariable("offset") int offset,@PathVariable("limit") int limit){
        int counter = 0;
        List<Juke> jukes = new ArrayList<>();
        List<Juke> allJukes = getAllJukes();
        if(offset < 0){
            return null;
        }

        for(int i=offset;i<allJukes.size();i++){
            if(counter<limit)
                jukes.add(allJukes.get(i));
                counter ++;
        }
        return jukes;
    }

    @RequestMapping("/jukes/id/{id}")
    public Juke getJukeById(@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();

        Juke juke = restTemplate.getForObject(uriJuke + id, Juke.class);
        return juke;
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

