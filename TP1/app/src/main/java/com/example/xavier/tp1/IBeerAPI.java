package com.example.xavier.tp1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Epulapp on 01/12/2017.
 */

public interface IBeerAPI {
    @GET("beers")
    Call<List<Beer>> listBeers(@Query("page") int page, @Query("per_page") int perPage);
}
