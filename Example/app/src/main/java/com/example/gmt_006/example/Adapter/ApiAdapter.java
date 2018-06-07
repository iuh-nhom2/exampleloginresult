package com.example.gmt_006.example.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gmt_006.example.Model.API;
import com.example.gmt_006.example.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ItemHolder> {
    Context context;
    ArrayList<API> arrayListAPI;

    public ApiAdapter(Context context, ArrayList<API> arrayListAPI) {
        this.context = context;
        this.arrayListAPI = arrayListAPI;
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.stream_api,null);
        ItemHolder itemHolder = new ItemHolder(v);

        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
         API api = arrayListAPI.get(position);
         holder.tenapi.setText(api.getName());
         Picasso.get().load(api.getImage()).placeholder(R.drawable.adddevice).error(R.drawable.password).into(holder.hinhapi);
    }

    @Override
    public int getItemCount() {
        return arrayListAPI.size();
    }
    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView hinhapi;
        public TextView tenapi;
        public ItemHolder(View itemView) {
            super(itemView);
            hinhapi = (ImageView) itemView.findViewById(R.id.imgAPI);
            tenapi = (TextView) itemView.findViewById(R.id.txttenapi);


        }
    }
}
