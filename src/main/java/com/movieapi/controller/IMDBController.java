package com.movieapi.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.movieapi.utils.ClientHttp;
import com.movieapi.utils.CreateUrl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IMDBController {
    @CrossOrigin
    @GetMapping("imdb/movies")
    public String getMovies(@RequestParam String id){
        ClientHttp clientHttp = new ClientHttp();
        CreateUrl createUrl = new CreateUrl();
        Gson gson = new Gson();

        String url = createUrl.getMovieById(id);
        String body = clientHttp.fetchData(url);
        System.out.println(body);

        JsonArray array = gson.fromJson(body, JsonArray.class);
        System.out.println("Title: "+array.get(0).getAsJsonObject().get("title"));

        return body;
    }
}
