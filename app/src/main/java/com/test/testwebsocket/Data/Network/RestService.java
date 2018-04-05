package com.test.testwebsocket.Data.Network;

import com.test.testwebsocket.Data.Network.response.TopRes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dzhafar on 05.04.18.
 */

public interface RestService {

    @GET("tops")
    Call<ArrayList<TopRes>> getTops(@Query("symbols") String symbols);
}
