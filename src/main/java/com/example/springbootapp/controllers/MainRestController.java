package com.example.springbootapp.controllers;

import com.example.springbootapp.model.UploadFileResponse;
import com.example.springbootapp.services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }


}