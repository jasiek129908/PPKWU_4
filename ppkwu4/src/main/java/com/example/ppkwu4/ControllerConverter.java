package com.example.ppkwu4;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ControllerConverter {

    @GetMapping("/api/{from}/{to}")
    public String convertString(@PathVariable("from") String fromFormat, @PathVariable("to") String targetFormat
            , @RequestBody String body) {
        return StringFormatUtil.formatString(fromFormat, targetFormat, body);
    }

    @GetMapping("/apiText/{from}/{to}")
    public String convertString2(@PathVariable("from") String fromFormat, @PathVariable("to") String targetFormat
            , @RequestParam("text") String textToFormat) {
        String response = null;
        switch (fromFormat) {
            case "csv":
                String responseApi = callExternalStringUtilityApi("http://localhost:1234/csv", textToFormat);
                response = StringFormatUtil.formatString("csv", textToFormat, responseApi);
                break;
            case "xml":
                responseApi = callExternalStringUtilityApi("http://localhost:1234/xml", textToFormat);
                response = StringFormatUtil.formatString("xml", textToFormat, responseApi);
                break;
            case "txt":
                responseApi = callExternalStringUtilityApi("http://localhost:1234/txt", textToFormat);
                response = StringFormatUtil.formatString("txt", textToFormat, responseApi);
                break;
            case "json":
                responseApi = callExternalStringUtilityApi("http://localhost:1234/json", textToFormat);
                response = StringFormatUtil.formatString("json", textToFormat, responseApi);
                break;
            default:
                break;
        }
        return response;
    }

    private String callExternalStringUtilityApi(String path, String textToProcess) {
        Mono<String> text = WebClient.create(path)
                .get()
                .uri(uriBuilder -> uriBuilder.path("")
                        .queryParam("text", textToProcess)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
        return text.block();
    }

}
