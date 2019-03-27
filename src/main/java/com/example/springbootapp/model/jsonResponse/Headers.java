package com.example.springbootapp.model.jsonResponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Accept",
        "Accept-Encoding",
        "Accept-Language",
        "Host",
        "Upgrade-Insecure-Requests",
        "User-Agent"
})
class Headers {

    @JsonProperty("Accept")
    private String accept;
    @JsonProperty("Accept-Encoding")
    private String acceptEncoding;
    @JsonProperty("Accept-Language")
    private String acceptLanguage;
    @JsonProperty("Host")
    private String host;
    @JsonProperty("Upgrade-Insecure-Requests")
    private String upgradeInsecureRequests;
    @JsonProperty("User-Agent")
    private String userAgent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

}