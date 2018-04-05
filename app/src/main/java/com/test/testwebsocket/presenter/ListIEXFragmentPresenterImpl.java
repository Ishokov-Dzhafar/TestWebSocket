package com.test.testwebsocket.presenter;

import com.test.testwebsocket.Data.Network.response.TopRes;
import com.test.testwebsocket.View.Interface.ListIEXFragmentView;
import com.test.testwebsocket.model.Interface.ListIEXFragmentInteractor;
import com.test.testwebsocket.model.ListIEXFragmentInteractorImpl;
import com.test.testwebsocket.presenter.Interface.ListIEXFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by dzhafar on 05.04.18.
 */

public class ListIEXFragmentPresenterImpl implements ListIEXFragmentPresenter {

    private ListIEXFragmentView view;
    private ListIEXFragmentInteractor interactor;

    public ListIEXFragmentPresenterImpl(ListIEXFragmentView view) {
        this.view = view;
        this.interactor = new ListIEXFragmentInteractorImpl(this);
    }

    @Override
    public void getTops(ArrayList<String> symbols) {
        String str = symbols.get(0);
        for (int i = 1; i < symbols.size(); i++) {
            str += "," + symbols.get(i);
        }
        interactor.getTops(str);
    }

    @Override
    public void onSuccessGETTops(ArrayList<TopRes> res) {
        view.onSuccessGETTops(res);
    }
}
