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
        "settings"
})
@Generated("jsonschema2pojo")
public class Setting {

    @JsonProperty("settings")
    private List<Setting__1> settings = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Setting() {
    }

    /**
     *
     * @param settings
     */
    public Setting(List<Setting__1> settings) {
        super();
        this.settings = settings;
    }

    @JsonProperty("settings")
    public List<Setting__1> getSettings() {
        return settings;
    }

    @JsonProperty("settings")
    public void setSettings(List<Setting__1> settings) {
        this.settings = settings;
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