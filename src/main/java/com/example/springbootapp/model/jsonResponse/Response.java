package com.example.springbootapp.model.jsonResponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "args",
        "headers",
        "origin",
        "url"
})
@Data
public class Response {

    @JsonProperty("args")
    private Args args;
    @JsonProperty("headers")
    private Headers headers;
    @JsonProperty("origin")
    private String origin;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();


}