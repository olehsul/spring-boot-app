package com.example.springbootapp.model.xmlResponse;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "slideshow")
public class Slideshow {
    @JacksonXmlProperty(localName = "title", isAttribute = true)
    private String title;
    @JacksonXmlProperty(localName = "date", isAttribute = true)
    private String date;
    @JacksonXmlProperty(localName = "author", isAttribute = true)
    private String author;
    @JacksonXmlProperty(localName = "data-livestyle-extension", isAttribute = true)
    private String dataLiveStyleExtension;

    @JacksonXmlElementWrapper(localName = "slide")
    private List<Slide> slides = new ArrayList<>();

    public Slideshow() {
    }



    public Slideshow(String title, String date, String author, String dataLiveStyleExtension, List<Slide> slides) {
        this.title = title;
        this.date = date;
        this.author = author;
        this.dataLiveStyleExtension = dataLiveStyleExtension;
        this.slides = slides;
    }
}
