package com.jedsada.listmovieup.listmovie;

import com.jedsada.listmovieup.listmovie.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("movie")
    Call<MovieModel> loadListMovie();
}
