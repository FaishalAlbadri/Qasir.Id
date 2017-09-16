package com.faishalbadri.qasirid.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.faishalbadri.qasirid.MainActivity;
import com.faishalbadri.qasirid.Model.Pojo;
import com.faishalbadri.qasirid.R;

import java.util.List;

/**
 * Created by faishal on 9/15/17.
 */

public class AdapterData extends RecyclerView.Adapter<AdapterData.SimpleViewHolder> {

    private final Context mContext;
    List<Pojo.DataBean> list_data;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        TextView txtJudul,txtMin,txtPlus;
        CardView cvItem;
        RecyclerView rvDalem;
        private AdapterDidalamData adapterDalem;
        public SimpleViewHolder(View view) {
            super(view);
            Context context = itemView.getContext();
            cvItem = (CardView)view.findViewById(R.id.cvItem);
            txtJudul = (TextView) view.findViewById(R.id.txt);
            txtMin = (TextView) view.findViewById(R.id.txtMin);
            txtPlus = (TextView) view.findViewById(R.id.txtPlus);
            rvDalem = (RecyclerView) itemView.findViewById(R.id.rvDalam);
            rvDalem.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            adapterDalem = new AdapterDidalamData();
            rvDalem.setAdapter(adapterDalem);
        }
    }

    public AdapterData(List<Pojo.DataBean> data, MainActivity list_data) {
        this.mContext = list_data;
        this.list_data = data;
    }

    public AdapterData.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        return new AdapterData.SimpleViewHolder(view);                                                                                                              //created by faishal
    }

    @Override
    public void onBindViewHolder(final AdapterData.SimpleViewHolder holder, final int position) {
        holder.txtJudul.setText(list_data.get(position).getProduct_name());
        holder.adapterDalem.setData(mContext,list_data.get(position).getVariants());
        holder.adapterDalem.setRowIndex(position);
        holder.txtMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    holder.rvDalem.setVisibility(View.GONE);
                    holder.txtMin.setVisibility(View.INVISIBLE);
                    holder.txtPlus.setVisibility(View.VISIBLE);

            }
        });
        holder.txtPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.rvDalem.setVisibility(View.VISIBLE);
                holder.txtMin.setVisibility(View.VISIBLE);
                holder.txtPlus.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

}

