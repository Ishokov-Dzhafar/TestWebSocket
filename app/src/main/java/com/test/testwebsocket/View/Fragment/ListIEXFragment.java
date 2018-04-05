package com.test.testwebsocket.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.test.testwebsocket.Data.Network.response.TopRes;
import com.test.testwebsocket.R;
import com.test.testwebsocket.View.Interface.ListIEXFragmentView;
import com.test.testwebsocket.adapters.IEXListAdapter;
import com.test.testwebsocket.presenter.Interface.ListIEXFragmentPresenter;
import com.test.testwebsocket.presenter.ListIEXFragmentPresenterImpl;

import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

/**
 * Created by dzhafar on 05.04.18.
 */

public class ListIEXFragment extends Fragment implements ListIEXFragmentView {

    private RecyclerView listIEX;
    private TextView logsTV;
    private EditText newSymbolET;
    private Button addBtn;
    private ListIEXFragmentPresenter presenter;
    private IEXListAdapter adapter;
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("https://ws-api.iextrading.com/1.0/tops");
        } catch (URISyntaxException e) {}
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_iex_fragment, container, false);
        listIEX =(RecyclerView) view.findViewById(R.id.listIEX);
        logsTV = (TextView) view.findViewById(R.id.logs);
        addBtn =(Button) view.findViewById(R.id.addBtn);
        newSymbolET =(EditText) view.findViewById(R.id.newSymbol);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!newSymbolET.getText().toString().isEmpty()) {
                    mSocket.emit("subscribe", newSymbolET.getText().toString().trim());
                    newSymbolET.setText("");
                }
            }
        });
        presenter = new ListIEXFragmentPresenterImpl(this);
        adapter = new IEXListAdapter();
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        listIEX.setLayoutManager(llm);
        listIEX.setAdapter(adapter);
        return view;
    }

    public void getData() {
        ArrayList<String> symbols = new ArrayList<>();
        symbols.add("SNAP");
        symbols.add("FB");
        symbols.add("AIG+");
        symbols.add("AAPL");
        symbols.add("MRO");
        presenter.getTops(symbols);
    }

    private Emitter.Listener onMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String str = args[0].toString();
                    logsTV.setText(str);
                    Gson gson = new Gson();
                    TopRes res =  gson.fromJson(str, TopRes.class);
                    updateSymbol(res);
                }
            });
        }
    };


    @Override
    public void onSuccessGETTops(ArrayList<TopRes> res) {
        adapter.setDataRes(res);
        adapter.notifyDataSetChanged();
        final String[] sym = {"SNAP", "FB", "AIG+", "AAPL", "MRO"};
        mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                mSocket.emit("subscribe", sym[0]);
                mSocket.emit("subscribe", sym[1]);
                mSocket.emit("subscribe", sym[2]);
                mSocket.emit("subscribe", sym[3]);
                mSocket.emit("subscribe", sym[4]);
            }
        }).on(Socket.EVENT_MESSAGE, onMessage);

        mSocket.connect();
    }

    public void updateSymbol(TopRes res) {
        adapter.insertOrUpdate(res);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPause() {
        super.onPause();
        mSocket.disconnect();
    }

    @Override
    public void onResume() {
        super.onResume();
        getData();
    }
}
