package com.test.testwebsocket.model;


import com.test.testwebsocket.Data.Managers.DataManager;
import com.test.testwebsocket.Data.Network.response.TopRes;
import com.test.testwebsocket.model.Interface.ListIEXFragmentInteractor;
import com.test.testwebsocket.presenter.Interface.ListIEXFragmentPresenter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dzhafar on 05.04.18.
 */

public class ListIEXFragmentInteractorImpl implements ListIEXFragmentInteractor {

    private ListIEXFragmentPresenter presenter;

    public ListIEXFragmentInteractorImpl(ListIEXFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getTops(String symbols) {
        Call<ArrayList<TopRes>> call = DataManager.getInstance().getTops(symbols);
        call.enqueue(new Callback<ArrayList<TopRes>>() {
            @Override
            public void onResponse(Call<ArrayList<TopRes>> call, Response<ArrayList<TopRes>> response) {
                switch (response.code()) {
                    case 200:
                        presenter.onSuccessGETTops(response.body());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TopRes>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
