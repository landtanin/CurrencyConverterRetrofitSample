package com.example.user.currencyconverter.manager;

import com.example.user.currencyconverter.models.CollectionModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by User on 6/5/2560.
 */

/**
 * Create Retrofit GET Http URL part
 */
public interface ApiService {

    // Create Retrofit GET Http URL part
    @GET("latest")
    Call<CollectionModel> exchangeRates(@Query("base") String base);
    // use CollectionModel class to receive the JSON string
}
