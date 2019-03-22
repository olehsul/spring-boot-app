package com.example.springbootapp.controllers;

import com.example.springbootapp.model.UploadFileResponse;
import com.example.springbootapp.model.jsonResponse.Response;
import com.example.springbootapp.model.xmlResponse.Slideshow;
import com.example.springbootapp.services.FileStorageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

@RestController
@RequestMapping("/api")
public class MainRestController {

    // paths.sendparams(application.yml)
    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("-------Params----");

    @GetMapping(value = "${paths.sendparams}")
    public ResponseEntity<String> sendParams(
            @RequestParam("param1") String param1,
            @RequestParam("param2") String param2
    ) {
        System.out.println(param1 + " " + param2);
        log.info(param1 + " " + param2);
        return new ResponseEntity<>("Everything is OK!", HttpStatus.OK);
    }

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/upload-file")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException, URISyntaxException {

        System.out.println("-------------inside uploadFile---------------");
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();


        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @GetMapping("/get-json")
    public void getJson() throws IOException {
        URL urlForGetRequest = new URL("https://httpbin.org/get");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();

            ObjectMapper mapper = new ObjectMapper();
            Response responseEntity = mapper.readValue(response.toString(), Response.class);

            System.out.println(responseEntity);

//            System.out.println("JSON String Result " + response.toString());
            //GetAndPost.POSTRequest(response.toString());
        } else {
            System.out.println("GET NOT WORKED");
        }
    }

    @GetMapping("/get-xml")
    public void getXml() throws IOException {
        URL urlForGetRequest = new URL("https://httpbin.org/xml");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();

            XmlMapper xmlMapper = new XmlMapper();
//            String xml = xmlMapper.writeValueAsString(new SpanShapeRenderer.Simple());  // serializing

            Slideshow value = xmlMapper.readValue("<slideshow     title=\"Sample Slide Show\"    date=\"Date of publication\"    author=\"Yours Truly\"    >    <!-- TITLE SLIDE -->    <slide type=\"all\">      <title>Wake up to WonderWidgets!</title>    </slide>    <!-- OVERVIEW -->    <slide type=\"all\">        <title>Overview</title>    </slide></slideshow>\n",
                    Slideshow.class);

//            Slideshow slideshow = xmlMapper.readValue(response.toString(), Slideshow.class);


            System.out.println(value);

        }
    }

}
