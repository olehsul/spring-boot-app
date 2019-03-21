package com.example.springbootapp.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class RequestInterceptor extends HandlerInterceptorAdapter {

    private org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger("-------Interceptor----");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-------------Interceptor Method--------------");
        if (request.getRequestURI().equals("/api/upload-file")) {
            log.info("[preHandle][" + request + "]" + "[" + request.getMethod()
                    + "]" + request.getRequestURI());

            String textFile = new BufferedReader(new InputStreamReader(request.getPart("file").getInputStream()))
                    .lines().collect(Collectors.joining("\n"));
            log.info("\n-----------------------------\n" + textFile + "\n---------------------------------\n");
//            System.out.println(textFile);
        }

        return true;
    }
}
