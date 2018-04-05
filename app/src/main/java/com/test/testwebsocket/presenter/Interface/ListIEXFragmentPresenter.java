package com.test.testwebsocket.presenter.Interface;

import com.test.testwebsocket.Data.Network.response.TopRes;

import java.util.ArrayList;

/**
 * Created by dzhafar on 05.04.18.
 */

public interface ListIEXFragmentPresenter {
    void getTops(ArrayList<String> symbols);
    void onSuccessGETTops(ArrayList<TopRes> res);
}
