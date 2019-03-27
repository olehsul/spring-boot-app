package com.example.springbootapp.model.xmlResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.util.List;
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Slide
{
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    @JacksonXmlProperty(localName = "title")
    private String title;
    @JacksonXmlElementWrapper(localName = "item")
    private List<Item> items;

    public Slide() {

    }

    public Slide(String title) {
        this.title = title;
    }

    public Slide(String type, String title, List<Item> items) {
        this.type = type;
        this.title = title;
        this.items = items;
    }

    public Slide(String type, String title) {
        this.type = type;
        this.title = title;
    }
}