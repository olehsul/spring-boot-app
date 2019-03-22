package com.example.springbootapp.model.xmlResponse;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private List<Slide> slides;

    public Slideshow() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDataLivestyleExtension() {
        return dataLiveStyleExtension;
    }

    public void setDataLivestyleExtension(String dataLivestyleExtension) {
        this.dataLiveStyleExtension = dataLivestyleExtension;
    }

    public String getDataLiveStyleExtension() {
        return dataLiveStyleExtension;
    }

    public void setDataLiveStyleExtension(String dataLiveStyleExtension) {
        this.dataLiveStyleExtension = dataLiveStyleExtension;
    }

    public List<Slide> getSlides() {
        return slides;
    }

    public void setSlides(List<Slide> slides) {
        this.slides = slides;
    }

    @Override
    public String toString() {
        return "Slideshow{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", dataLiveStyleExtension='" + dataLiveStyleExtension + '\'' +
                ", slides=" + slides +
                '}';
    }
}
