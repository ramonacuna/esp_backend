package com.espe.infrastructure.controller;

import com.espe.infrastructure.utility.mapper.HttpModelResponse;
import com.espe.infrastructure.utility.response.HttpResponse;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController()
public class BeginController {

    private final Environment environment;

    public BeginController(Environment environment) {
        this.environment = environment;
    }

    public Map<String, Object> buildResponse(){
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("Name","Specialization's curse api 2025");
        data.put("version", "0.2.0");
        data.put("Status", "Ok");
        data.put("SpringBoot profiles", environment.getActiveProfiles());
        return data;
    }

    @GetMapping(path = "/")
    public ResponseEntity<HttpModelResponse<Map<String,Object>>> Welcome() {
        return HttpResponse.ok("it's working!!", buildResponse());
    }
}
