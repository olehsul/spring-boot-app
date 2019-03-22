package com.example.springbootapp.model.xmlResponse;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Slide
{
    @JacksonXmlProperty(localName = "type", isAttribute = true)
    private String type;
    @JacksonXmlProperty(localName = "title")
    private String title;
//    @JacksonXmlElementWrapper(localName = "item")
//    private List<Item> items;

    public Slide() {

    }

    public Slide(String title) {
        this.title = title;
    }

    public Slide(String type, String title, List<Item> items) {
        this.type = type;
        this.title = title;
//        this.items = items;
    }

    public Slide(String type, String title) {
        this.type = type;
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }

    @Override
    public String toString() {
        return "Slide{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
//                ", items=" + items +
                '}';
    }
}