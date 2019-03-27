package com.example.springbootapp.model.jsonResponse;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class Args {

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

}