package com.example.springbootapp.model.xmlResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class Item
{
    @JacksonXmlCData
    @JacksonXmlText
    private String note;

    @JacksonXmlProperty
    private String em;


    public Item() {
    }

    public Item(String em) {
        this.em = em;
    }

    public Item(String note, String em) {
        this.note = note;
        this.em = em;
    }
}