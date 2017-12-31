package com.example.xavier.tp1;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Epulapp on 01/12/2017.
 */

public class BeerAPI {
    private IBeerAPI API;

    public BeerAPI()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.punkapi.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API = retrofit.create(IBeerAPI.class);
    }

    public Call<List<Beer>> getBeerList(int nPage, int nPerPage)
    {
        Call<List<Beer>> beersCall = API.listBeers(nPage, nPerPage);
        return beersCall;
    }

}
