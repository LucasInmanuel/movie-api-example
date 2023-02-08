package com.movieapi.utils;

public class CreateUrl {

    String key = GetPropertyValues.getPropValues("key");
    String language = GetPropertyValues.getPropValues("language");

    public String getMovies(){

        return "https://jsonplaceholder.typicode.com/posts";

    }

    public String getMovieById(String id){

        return "https://jsonplaceholder.typicode.com/posts?id=" + id;

    }

//    "https://api.themoviedb.org/3/search/movie" + "?api_key=" + key + "&query=" + search + "&language=" + language
//                + "&page=" + pageNumber;

}