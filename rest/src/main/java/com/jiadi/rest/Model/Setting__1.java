package com.jiadi.rest.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "requires"
})
@Generated("jsonschema2pojo")
public class Setting__1 {

    @JsonProperty("id")
    private String id;
    @JsonProperty("requires")
    private List<String> requires = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    /**
     * No args constructor for use in serialization
     *
     */
    public Setting__1() {
    }

    /**
     *
     * @param id
     * @param requires
     */
    public Setting__1(String id, List<String> requires) {
        super();
        this.id = id;
        this.requires = requires;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("requires")
    public List<String> getRequires() {
        return requires;
    }

    @JsonProperty("requires")
    public void setRequires(List<String> requires) {
        this.requires = requires;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}