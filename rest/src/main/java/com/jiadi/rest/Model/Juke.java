package com.jiadi.rest.Model;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;

public class Juke {
    private long id;
    private String model;
    private ArrayList<Componant> componants;

    @Builder
    public Juke(long id, String model, ArrayList<Componant> componants) {
        this.id = id;
        this.model = model;
        this.componants = componants;
    }


    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<Componant> getComponants() {
        return componants;
    }
}
