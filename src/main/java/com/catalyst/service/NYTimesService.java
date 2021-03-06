package com.catalyst.service;

import com.catalyst.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class NYTimesService {


    @Autowired
    private RestTemplate restTemplate;

    public Response getNYTimesArticles() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", String.valueOf(MediaType.TEXT_PLAIN));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        Map<String, String> params = new HashMap<String, String>();
        params.put("section", "all-sections");
        params.put("period", "1");

        String url = "https://api.nytimes.com/svc/mostpopular/v2/mostviewed/{section}/{period}.json?api-key=923a4ac896be4056bdfae937492c8b1e";
        URI uri = UriComponentsBuilder.fromUriString(url)
                .buildAndExpand(params)
                .toUri();

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<Response> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                entity,
                Response.class);

        return response.getBody();
    }
}
