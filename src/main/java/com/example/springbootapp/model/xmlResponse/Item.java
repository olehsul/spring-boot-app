package com.example.springbootapp.model.xmlResponse;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.Arrays;

class Item
{
    @JacksonXmlText
    private String note1;
    @JacksonXmlProperty(localName = "em")
    private String em;
//    @JacksonXmlText
//    private String note2;

    public Item() {
    }

    public Item(String note1, String em, String note2) {
        this.note1 = note1;
        this.em = em;
//        this.note2 = note2;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    @Override
    public String toString() {
        return "Item{" +
                "note1='" + note1 + '\'' +
                ", em='" + em + '\'' +
                '}';
    }

    //    public String getNote2() {
//        return note2;
//    }
//
//    public void setNote2(String note2) {
//        this.note2 = note2;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "note1='" + note1 + '\'' +
//                ", em='" + em + '\'' +
//                ", note2='" + note2 + '\'' +
//                '}';
//    }
}