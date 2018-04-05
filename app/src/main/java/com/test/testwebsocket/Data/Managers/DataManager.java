package com.test.testwebsocket.Data.Managers;


import com.test.testwebsocket.Data.Network.RestService;
import com.test.testwebsocket.Data.Network.ServiceGenerator;
import com.test.testwebsocket.Data.Network.response.TopRes;

import java.util.ArrayList;

import retrofit2.Call;

/**
 * Created by dzhafar on 05.04.18.
 */

public class DataManager {

    private static DataManager ourInstance = null;
    private RestService mRestService;

    public static DataManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new DataManager();
        }
        return ourInstance;
    }

    private DataManager() {
        this.mRestService = ServiceGenerator.createService(RestService.class);
    }

    //---------------------RestAPI-----------------------------------

    public Call<ArrayList<TopRes>> getTops(String symbols) {
        return mRestService.getTops(symbols);
    }

}
