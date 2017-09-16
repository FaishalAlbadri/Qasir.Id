package com.faishalbadri.qasirid.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.faishalbadri.qasirid.Model.Pojo;
import com.faishalbadri.qasirid.R;

import java.util.List;

/**
 * Created by faishal on 9/15/17.
 */

public class AdapterDidalamData extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<Pojo.DataBean.VariantsBean> list_data;
    private int mRowIndex = 3;

    public AdapterDidalamData() {

    }

    public void setData(Context context ,List<Pojo.DataBean.VariantsBean> data) {
        list_data = data;
        mContext = context;
    }

    public void setRowIndex(int index) {
        mRowIndex = index;
    }


    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView txtDalem,txtPrice;
        private ImageView imgDalem;
        private CardView cvDalem;
        private CardView btnDalem;

        public ItemViewHolder(View itemView) {
            super(itemView);
            txtDalem = (TextView) itemView.findViewById(R.id.txtdalam);
            txtPrice = (TextView) itemView.findViewById(R.id.txtPrice);
            imgDalem = (ImageView) itemView.findViewById(R.id.imgdalam);
            cvDalem = (CardView) itemView.findViewById(R.id.cvdalam);
            btnDalem = (CardView) itemView.findViewById(R.id.btnDalem);
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_dalam, parent, false);
        ItemViewHolder holder = new ItemViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder rawHolder, final int position) {                                                                               // created by Ahmad Faishal Albadri
        ItemViewHolder holder = (ItemViewHolder) rawHolder;
        final Pojo.DataBean.VariantsBean listItem = list_data.get(position);
        holder.txtDalem.setText(list_data.get(position).getVariant_name());
        holder.txtPrice.setText("Rp."+list_data.get(position).getPrice());
        holder.btnDalem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "Harganya Rp."+list_data.get(position).getPrice(), Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(mContext)
                .load(list_data.get(position).getImage())
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imgDalem);
        holder.cvDalem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

}