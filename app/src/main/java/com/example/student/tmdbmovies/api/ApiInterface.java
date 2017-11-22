package com.example.student.tmdbmovies.api;

import com.example.student.tmdbmovies.models.MovieResult;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Student on 7/22/2017.
 */

public interface ApiInterface {

    @GET("/3/movie/popular?api_key=194d15963660b70c0bd9b51ebaadde17")
    Call<MovieResult> getMovies();
}
