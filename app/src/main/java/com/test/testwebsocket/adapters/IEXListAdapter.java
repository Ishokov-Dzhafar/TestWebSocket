package com.test.testwebsocket.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.testwebsocket.Data.Network.response.TopRes;
import com.test.testwebsocket.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzhafar on 05.04.18.
 */

public class IEXListAdapter extends RecyclerView.Adapter<IEXListAdapter.ViewHolder> {

    private Map<String, TopRes> dataRes;

    public IEXListAdapter() {
        dataRes = new HashMap<String, TopRes>();
    }

    public void setDataRes(ArrayList<TopRes> dataRes) {
        this.dataRes.clear();
        for (TopRes data: dataRes) {
            this.dataRes.put(data.getSymbol(), data);
        }
        notifyDataSetChanged();
    }

    public void insertOrUpdate (TopRes res) {
        if (dataRes.containsKey(res.getSymbol())) {
            dataRes.remove(res.getSymbol());
        }
        dataRes.put(res.getSymbol(), res);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.iex_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArrayList<TopRes> res = new ArrayList<>(dataRes.values());
        holder.symbolTV.setText(res.get(position).getSymbol());
        holder.askPriceTV.setText(res.get(position).getAskPrice());
        holder.lastScalePriceTV.setText(res.get(position).getLastSalePrice());
    }

    @Override
    public int getItemCount() {
        return dataRes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView symbolTV;
        private TextView lastScalePriceTV;
        private TextView askPriceTV;

        public ViewHolder(View itemView) {
            super(itemView);
            symbolTV = itemView.findViewById(R.id.symbol);
            lastScalePriceTV = itemView.findViewById(R.id.lastScalePrice);
            askPriceTV = itemView.findViewById(R.id.askPrice);
        }
    }
}
