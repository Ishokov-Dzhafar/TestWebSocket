package com.test.testwebsocket.View.Interface;

import com.test.testwebsocket.Data.Network.response.TopRes;

import java.util.ArrayList;

/**
 * Created by dzhafar on 05.04.18.
 */

public interface ListIEXFragmentView {

    void onSuccessGETTops(ArrayList<TopRes> res);
}
