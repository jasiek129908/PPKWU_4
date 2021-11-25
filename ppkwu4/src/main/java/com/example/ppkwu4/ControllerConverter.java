package com.example.ppkwu4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerConverter {

    @GetMapping("/api/{from}/{to}")
    public String convertString(@PathVariable("from") String fromFormat, @PathVariable("to") String targetFormat
                                , @RequestBody String body)
    {
        return StringFormatUtil.formatString(fromFormat,targetFormat,body);
    }


}
